# Matrix Layer Rotation

**Problem:** [Matrix Layer Rotation](https://www.hackerrank.com/challenges/matrix-rotation-algo/problem)

## Summary

Rotate an m×n matrix by r steps counter-clockwise, where rotation is applied independently to each "layer" (concentric ring around the center).

## Approach

For each layer, extract the ring as a 1D list, rotate it by r mod layerSize (shift left), then write the ring back into the matrix. Repeat for all layers from outermost to innermost.

## Solution Details

- **Result.matrixRotation:**

```java
public static void matrixRotation(List<List<Integer>> matrix, int r) {
    int m = matrix.size();
    int n = matrix.get(0).size();
    int layers = Math.min(m, n) / 2;

    for (int layer = 0; layer < layers; layer++) {
        List<Integer> layerElements = extractLayer(matrix, layer);
        int layerSize = layerElements.size();
        int rotations = r % layerSize;

        List<Integer> rotated = new ArrayList<>();
        for (int i = 0; i < layerSize; i++) {
            rotated.add(layerElements.get((i + rotations) % layerSize));
        }
        placeLayer(matrix, layer, rotated);
    }
    printMatrix(matrix);
}
```

## Time and Space Complexity

- **Time:** O(m·n)
- **Space:** O(m + n) per layer for the ring

## Example

| Input | Output |
|-------|--------|
| 2×2 matrix, r=1 | matrix rotated one step CCW per layer |
