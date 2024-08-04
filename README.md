# Tiny Blockchain in Scala

This project demonstrates a basic implementation of a blockchain in Scala. The goal is to understand the core concepts of blockchain technology, including blocks, hashing, proof-of-work, and chain validation.

## Project Structure

```
tinychain/
│
├── build.sbt
├── project/
│   └── build.properties
├── src/
│   ├── main/
│   │   ├── scala/
│   │   │   ├── Block.scala
│   │   │   ├── Blockchain.scala
│   │   │   └── Main.scala
│   └── test/
│       └── scala/
│           └── BlockchainSpec.scala
```

## Setup

### Prerequisites

- [sbt](https://www.scala-sbt.org/download.html) (Simple Build Tool) installed
- Java JDK installed

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/tal7aouy/tinychain.git
   cd tinychain
   ```

### Running the Project

1. **Navigate to the project directory**:

   ```bash
   cd tinychain
   ```

2. **Compile and run the project**:
   ```bash
   sbt run
   ```

### Running Tests

To run the tests, execute the following command:

```bash
sbt test
```

## Project Files

### Block.scala

Defines the `Block` class, which represents a block in the blockchain. Each block contains:

- `index`: The position of the block in the blockchain.
- `timestamp`: The time the block was created.
- `data`: The data stored in the block.
- `previousHash`: The hash of the previous block.
- `hash`: The hash of the current block.
- `nonce`: The number used once, for the proof-of-work.

### Blockchain.scala

Defines the `Blockchain` class, which manages the chain of blocks. The main methods include:

- `createGenesisBlock`: Creates the first block in the blockchain.
- `getLatestBlock`: Retrieves the most recent block.
- `addBlock`: Adds a new block to the chain with proof-of-work.
- `proofOfWork`: Ensures a certain amount of computational work has been done to add a new block.
- `isValidChain`: Validates the integrity of the blockchain.

### Main.scala

The entry point for the application. It demonstrates adding new blocks to the blockchain and validating the chain.

### BlockchainSpec.scala

Contains test cases to ensure the blockchain functions correctly. It uses ScalaTest to validate:

- The blockchain starts with a genesis block.
- New blocks are added correctly with valid proof-of-work.
- The blockchain is validated correctly.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
