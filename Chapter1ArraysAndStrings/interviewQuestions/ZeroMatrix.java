package interviewQuestions;

import java.util.Random;

public class ZeroMatrix {

	/*
	 * Problem set: Zero Matrix
	 * Write an algorithm such that if an element in an MxN matrix is 0,
	 * its entire row and column are set to 0
	 */
	
	public static void setColToZero(int[][] image, int colNumber) {
		int numberOfRows = image.length;
		for (int i = 0; i < numberOfRows; i++) {
			image[i][colNumber] = 0;
		}
	}
	
	public static void setRowToZero(int[][] image, int rowNumber) {
		int numberOfColumns = image[0].length;
		for (int i = 0; i < numberOfColumns; i++) {
			image[rowNumber][i] = 0;
		}
	}
	
	public static int[][] zeroMatrix(int[][] image) {
		int[][] newImage = deepCopy(image);
		int numberOfRows = newImage.length;
		int numberOfColumns = newImage[0].length;
		
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (image[i][j] == 0) {
					setRowToZero(newImage, i);
					setColToZero(newImage, j);
				}
			}
		}
		return newImage;
	}
	
	public static int[][] deepCopy(int[][] source) {
		int numberOfRows = source.length;
		int numberOfColumns = source[0].length;
		int[][] destination = new int[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				destination[i][j] = source[i][j];
			}
		}
		return destination;
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
		int row = 10;
		int col = 10;
		
		int[][] image = new int[row][col];
		Random r = new Random();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				image[i][j] = r.nextInt(240);
			}
		}
//		
		image[0][0] = 0;
		image[2][2] = 0;
		
		int[][] zeroImage = zeroMatrix(image);
		
		System.out.println("Original Image: ");
		printImage(image);
		
		System.out.println("Zero Image: ");
		printImage(zeroImage);
		
	}

}
