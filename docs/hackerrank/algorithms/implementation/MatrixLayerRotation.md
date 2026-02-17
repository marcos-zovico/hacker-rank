# Matrix Layer Rotation

**Problem:** [Matrix Layer Rotation](https://www.hackerrank.com/challenges/matrix-rotation-algo/problem)

## Summary

Rotate an m×n matrix by r steps counter-clockwise, where rotation is applied independently to each "layer" (concentric ring around the center).

## Approach

For each layer, extract the ring as a 1D list, rotate it by r mod layerSize (shift left), then write the ring back into the matrix. Repeat for all layers from outermost to innermost.

## Solution Details

- **Layers:** Number of rings is `layers = Math.min(m, n) / 2`. Each layer is extracted in one direction (top → right → bottom → left), rotated as a 1D list, then written back in the same order.

- **Per-layer rotation:** Use `r % layerSize` so we only shift by a value in [0, layerSize). Rotated list: new position `i` gets the value that was at `(i + rotations) % layerSize` (left shift):

```java
int rotations = r % layerSize;
List<Integer> rotated = new ArrayList<>();
for (int i = 0; i < layerSize; i++) {
    rotated.add(layerElements.get((i + rotations) % layerSize));
}
```

- **Extract order (same as place order):** Top row left→right, right column (no corners), bottom row right→left if distinct from top, left column bottom→top (no corners):

```java
// Top row
for (int j = layer; j < n - layer; j++)
    elements.add(matrix.get(layer).get(j));
// Right column
for (int i = layer + 1; i < m - layer - 1; i++)
    elements.add(matrix.get(i).get(n - layer - 1));
// Bottom row (if different from top)
if (m - layer - 1 > layer)
    for (int j = n - layer - 1; j >= layer; j--)
        elements.add(matrix.get(m - layer - 1).get(j));
// Left column
for (int i = m - layer - 2; i > layer; i--)
    elements.add(matrix.get(i).get(layer));
```

- **Place:** Same traversal; assign `elements.get(idx++)` into each cell in that order. Extract and place use the same indexing so the ring stays consistent.

## Time and Space Complexity

- **Time:** O(m·n)
- **Space:** O(m + n) per layer for the ring

## Example

| Input | Output |
|-------|--------|
| 2×2 matrix, r=1 | matrix rotated one step CCW per layer |
