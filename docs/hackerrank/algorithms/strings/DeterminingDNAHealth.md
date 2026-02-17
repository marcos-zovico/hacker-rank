# Determining DNA Health

**Problem:** [Determining DNA Health](https://www.hackerrank.com/challenges/determining-dna-health/problem)

## Summary

Given genes with health values and a range [first, last], compute the total health of a DNA strand: sum of health values for every gene in the range that appears as a substring of the strand.

## Approach

Build an Aho-Corasick automaton from the genes. For each strand, run the automaton over the text and sum health only for matches whose gene index is in [first, last].

## Solution Details

- **Aho-Corasick:** Multi-pattern matching in O(|text| + number of matches). Build a trie of genes, add failure links (like KMP), then traverse the text once. At each node, collect output (gene index and health) and sum health for indices in [first, last].

- **Trie and failure:** Each node has children and a fail pointer. Outputs at a node include outputs from the fail node. When we follow a character and have no child, follow fail until we do or reach root.

- **Health sum:** `calculateHealth(first, last, d)` walks the automaton over d; at each node it adds health for each output whose gene index is between first and last.

## Time and Space Complexity

- **Time:** O(total length of genes + total length of strands + matches)
- **Space:** O(total size of trie)

## Example

| Input | Output |
|-------|--------|
| genes, health, ranges, strands | min and max health over all strands |
