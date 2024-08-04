import scala.annotation.tailrec

class Blockchain {
  var chain: List[Block] = List(createGenesisBlock())

  def createGenesisBlock(): Block = {
    Block(0, System.currentTimeMillis(), "Genesis Block", "0", 0)
  }

  def getLatestBlock(): Block = chain.last

  def addBlock(data: String, difficulty: Int): Unit = {
    val previousBlock = getLatestBlock()
    val newBlock = proofOfWork(previousBlock.index + 1, System.currentTimeMillis(), data, previousBlock.hash, difficulty)
    chain = chain :+ newBlock
  }

  def proofOfWork(index: Int, timestamp: Long, data: String, previousHash: String, difficulty: Int): Block = {
    @tailrec
    def mine(nonce: Int): Block = {
      val hash = Block.calculateHash(index, timestamp, data, previousHash, nonce)
      if (hash.substring(0, difficulty) == "0" * difficulty) {
        Block(index, timestamp, data, previousHash, nonce)
      } else {
        mine(nonce + 1)
      }
    }

    mine(0)
  }

  def isValidChain(chain: List[Block]): Boolean = {
    @tailrec
    def validate(chain: List[Block]): Boolean = chain match {
      case head :: Nil => true
      case head :: tail =>
        val isValidHash = head.hash == Block.calculateHash(head.index, head.timestamp, head.data, head.previousHash, head.nonce)
        val isValidPrevHash = head.previousHash == tail.head.hash
        isValidHash && isValidPrevHash && validate(tail)
      case Nil => false
    }

    validate(chain.reverse)
  }
}
