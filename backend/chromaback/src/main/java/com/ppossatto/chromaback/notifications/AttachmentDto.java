package com.ppossatto.chromaback.notifications;

public record AttachmentDto(
   String fileName,
   String contentType,
   String url,
   long size
) {
}
