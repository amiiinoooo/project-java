import java.util.Scanner;

public class Student_grades {

	public static void fillArrays(String names[], float grades[], int nb) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < nb; i++) {
			String checkName;
			do {
				System.out.printf("Enter the name of student %d (no duplicates): \n", i + 1);
				checkName = sc.next();
			} while (nameUsed(names, nb, checkName));
			names[i] = checkName;

			do {
				System.out.printf("Enter the grade of student %d (between 0 and 100): \n", i + 1);
				grades[i] = sc.nextFloat();
			} while (grades[i] > 100 || grades[i] < 0);
		}
	}

	public static boolean nameUsed(String names[], int nb, String s) {
		for (int i = 0; i < nb; i++) {
			if (s.equals(names[i])) {
				return true;
			}
		}
		return false;
	}

	public static int addStudent(String names[], float grades[], int nb) {
		Scanner sc = new Scanner(System.in);

		if (nb < 30) {
			nb++;
			String checkName;
			do {
				System.out.printf("Enter the name of student %d (no duplicates): \n", nb);
				checkName = sc.next();
			} while (nameUsed(names, nb, checkName));
			names[nb - 1] = checkName;

			do {
				System.out.printf("Enter the grade of student %d (between 0 and 100): \n", nb);
				grades[nb - 1] = sc.nextFloat();
			} while (grades[nb - 1] > 100 || grades[nb - 1] < 0);

		}

		else {
			System.out.printf("You reached the limit of students number");

		}

		return nb;
	}

	public static void gradesList(String names[], float grades[], int nb) {

		for (int i = 0; i < nb; i++) {
			System.out.printf("Student %d: %s		%.2f \n", i + 1, names[i], grades[i]);
		}
	}

	public static void maxGrade(String names[], float grades[], int nb) {
		float max = 0;
		int a = 0;
		for (int i = 0; i < nb; i++) {
			if (max < grades[i]) {
				max = grades[i];
				a = i;
			}
		}
		System.out.printf("Student %s: %.2f \n", names[a], grades[a]);
	}

	public static void minGrade(String names[], float grades[], int nb) {
		float min = grades[0];
		int a = 0;
		for (int i = 0; i < nb; i++) {
			if (min > grades[i]) {
				min = grades[i];
				a = i;
			}
		}

		System.out.printf("Student %s: %.2f \n", names[a], grades[a]);
	}

	public static void avgGrade(String names[], float grades[], int nb) {
		float avg = 0;
		for (int i = 0; i < nb; i++)
			avg += grades[i];

		avg /= nb;
		System.out.printf("The average grade: %.2f \n", avg);

	}

	public static void insertionSort(float[] array, int nb) {
		for (int i = 1; i < nb; i++) {
			float key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	public static void selectionSort(float[] array, int nb) {
		for (int i = 0; i < nb - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nb; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			float temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	public static void bubbleSort(float[] array, int nb) {
		for (int i = 0; i < nb - 1; i++) {
			for (int j = 0; j < nb - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					float temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void passOrFail(String names[], float grades[], int nb) {
		for (int i = 0; i < nb; i++) {
			if (grades[i] >= 50) {
				System.out.printf("%s : Pass\n", names[i]);
			}

			if (grades[i] < 50) {
				System.out.printf("%s : Fail\n", names[i]);
			}
		}
	}

	public static void main(String[] args) {

		long start = System.nanoTime();

		Scanner sc = new Scanner(System.in);
		int nb = 0;
		do {
			System.out.printf("Enter the number of students (less than 30): ");
			nb = sc.nextInt();
		} while (nb > 30 || nb < 0);

		String names[] = new String[30];
		float grades[] = new float[30];
		fillArrays(names, grades, nb);
		int o = 0;

		do {

			System.out.printf("\n");
			System.out.printf("Menu:\n");
			System.out.printf("1.Add students \n");
			System.out.printf("2.Show grades' list \n");
			System.out.printf("3.Show max grade \n");
			System.out.printf("4.Show min grade \n");
			System.out.printf("5.Show avg grade \n");
			System.out.printf("6.Sort the grades (insertion) \n");
			System.out.printf("7.Sort the grades (selection) \n");
			System.out.printf("8.Sort the grades (bubble)\n");
			System.out.printf("9.Pass or fail\n");
			System.out.printf("10.Quit menu \n\n");

			do {
				System.out.printf("Enter an option: ");

				o = sc.nextInt();
				System.out.printf("\n");
			} while (o > 10 || o < 1);

			switch (o) {
			case 1:
				nb = addStudent(names, grades, nb);
				break;
			case 2:
				gradesList(names, grades, nb);
				break;
			case 3:
				maxGrade(names, grades, nb);
				break;
			case 4:
				minGrade(names, grades, nb);
				break;
			case 5:
				avgGrade(names, grades, nb);
				break;
			case 6:
				insertionSort(grades, nb);
				break;
			case 7:
				selectionSort(grades, nb);
				break;
			case 8:
				bubbleSort(grades, nb);
				break;
			case 9:
				passOrFail(names, grades, nb);
				break;
			case 10:
				System.out.printf("Goodbye !\n");
				break;
			}
		} while (o < 10);

		long end = System.nanoTime();
		long execution = (end - start);
		System.out.println("Execution time:");
		System.out.println(execution / 1000000000 + " seconds");
		System.out.println(execution + " nanoseconds");

	}

}