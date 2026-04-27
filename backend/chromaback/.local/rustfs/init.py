import boto3
import os
from botocore.exceptions import ClientError

def create_bucket(client, bucket_name):
    try:
        client.create_bucket(Bucket=bucket_name)
        print(f"Bucket '{bucket_name}' successfully created.")
    except ClientError as e:
        if e.response["Error"]["Code"] == "BucketAlreadyOwnedByYou":
            print(f"Bucket '{bucket_name}' already exists, ignoring...")
        else:
            raise

def apply_lifecycle_policy(client, bucket_name, days, prefix=None):
    rules = [
        {
            "ID": f"expiry-{bucket_name}",
            "Status": "Enabled",
            "Expiration": {"Days": days},
            **({"Filter": {"Prefix": prefix}} if prefix else {"Filter": {}})
        }
    ]
    client.put_bucket_lifecycle_configuration(
        Bucket=bucket_name,
        LifecycleConfiguration={"Rules": rules}
    )
    print(f"Retention policy of {days} days applyed for bucket '{bucket_name}'.")

def main():
    client = boto3.client(
        "s3",
        endpoint_url=os.environ["RUSTFS_ENDPOINT"],
        aws_access_key_id=os.environ["RUSTFS_ACCESS_KEY"],
        aws_secret_access_key=os.environ["RUSTFS_SECRET_KEY"],
        region_name="us-east-1"
    )

    create_bucket(client, "chromamon-documents")
    create_bucket(client, "chromamon-images")
    create_bucket(client, "chromamon-exports")

    apply_lifecycle_policy(client, "chromamon-documents", days=60, prefix="reports/")

    apply_lifecycle_policy(client, "chromamon-images", days=365, prefix="analyses/")

    apply_lifecycle_policy(client, "chromamon-exports", days=365)

    print("RustFS initialization finished!")

if __name__ == "__main__":
    main()