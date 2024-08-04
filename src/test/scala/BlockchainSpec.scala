import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BlockchainSpec extends AnyFlatSpec with Matchers {
  "A Blockchain" should "start with a genesis block" in {
    val blockchain = new Blockchain()
    blockchain.chain.length should be (1)
    blockchain.chain.head.data should be ("Genesis Block")
  }

  it should "add new blocks with valid proof of work" in {
    val blockchain = new Blockchain()
    blockchain.addBlock("First block data", 4)
    blockchain.chain.length should be (2)
    blockchain.chain.last.data should be ("First block data")
  }

  it should "validate the blockchain" in {
    val blockchain = new Blockchain()
    blockchain.addBlock("First block data", 4)
    blockchain.isValidChain(blockchain.chain) should be (true)
  }
}
