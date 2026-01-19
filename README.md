# Huffman Compression–Decompression (Java)

Lightweight CLI tool for lossless file compression and decompression using Huffman coding.

## Highlights
- End-to-end CLI for `compress` and `decompress`
- Efficient bit-level I/O for compact outputs
- Dependency-free, implemented with Java SE
- Clear usage and minimal setup

## Tech Stack
- Java 11+

## Build & Run
```bash
javac -d bin src/module-info.java src/huff/*.java
java -cp bin huff.Main compress <input> <output>
java -cp bin huff.Main decompress <input> <output>
```

## Example
- Compress: `java -cp bin huff.Main compress r.txt r.huff`
- Decompress: `java -cp bin huff.Main decompress r.huff r.out.txt`

## Minimal Structure
- `src/huff/` core implementation and CLI
- `bin/` compiled classes

## Key Contributions
- Implemented Huffman pipeline (frequencies → tree → codes → header)
- Designed bit-stream I/O for space efficiency
- Added clear CLI UX and helpful usage messages