package com.ppossatto.chromaback.notifications;

import java.util.List;

public record EmailEvent(
   String from,
   List<String> to,
   String body,
   String subject,
   List<AttachmentDto> attachments
) {
}
