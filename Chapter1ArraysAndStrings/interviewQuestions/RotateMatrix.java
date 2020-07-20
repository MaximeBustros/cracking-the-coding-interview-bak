package interviewQuestions;
import java.util.Random;
public class RotateMatrix {

	/*
	 * Problem set: Rotate Matrix
	 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
	 * write a method to rotate the image by 90 degrees
	 */
	
	public static int[][] rotate90Clockwise(int[][] image) {
		int numberOfRows = image.length;
		int numberOfColumns = image[1].length;
		int[][] rotatedImage = new int[numberOfColumns][numberOfRows];
		
		// run through the original image
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				rotatedImage[j][numberOfRows - i - 1] = image[i][j];
			}
		}
		return rotatedImage;
	}
	
	public static void printImage(int[][] image) {
		int rows = image.length;
		int cols = image[0].length;
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(image[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int row = 2;
		int col = 3;
		
		int[][] image = new int[row][col];
		Random r = new Random();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				image[i][j] = r.nextInt(240);
			}
		}
		
		int[][] rotatedImage = rotate90Clockwise(image);
		
		System.out.println("Original Image: ");
		printImage(image);
		
		System.out.println("Rotated Image: ");
		printImage(rotatedImage);
	}

}
