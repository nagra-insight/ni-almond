package almond.protocol

object Complete {

  final case class Request(
    code: String,
    cursor_pos: Int
  )

  final case class Reply(
    matches: List[String],
    cursor_start: Int,
    cursor_end: Int,
    metadata: RawJson,
    status: String
  )

  object Reply {

    def apply(
      matches: List[String],
      cursor_start: Int,
      cursor_end: Int,
      metadata: RawJson
    ): Reply =
      Reply(
        matches,
        cursor_start,
        cursor_end,
        metadata,
        "ok"
      )

  }


  def requestType = MessageType[Request]("complete_request")
  def replyType = MessageType[Reply]("complete_reply")

}
