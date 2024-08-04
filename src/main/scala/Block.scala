import java.security.MessageDigest

case class Block(index: Int, timestamp: Long, data: String, previousHash: String, hash: String, nonce: Int)

object Block {
  def apply(index: Int, timestamp: Long, data: String, previousHash: String, nonce: Int): Block = {
    val hash = calculateHash(index, timestamp, data, previousHash, nonce)
    new Block(index, timestamp, data, previousHash, hash, nonce)
  }

  def calculateHash(index: Int, timestamp: Long, data: String, previousHash: String, nonce: Int): String = {
    val input = s"$index$timestamp$data$previousHash$nonce"
    val bytes = MessageDigest.getInstance("SHA-256").digest(input.getBytes("UTF-8"))
    bytes.map("%02x".format(_)).mkString
  }
}
