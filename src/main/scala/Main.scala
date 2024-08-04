object Main extends App {
  val blockchain = new Blockchain()

  println("Mining block 1...")
  blockchain.addBlock("First block data", 4)
  println(s"Block 1: ${blockchain.getLatestBlock()}")

  println("Mining block 2...")
  blockchain.addBlock("Second block data", 4)
  println(s"Block 2: ${blockchain.getLatestBlock()}")

  println(s"Blockchain valid: ${blockchain.isValidChain(blockchain.chain)}")
}
