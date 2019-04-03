import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainLoop {
	
	public static Scanner scan = new Scanner(System.in);

	public static void loop() {
		Integer numb0 = 0;
		Integer numb1 = 0;
		boolean go0 = true, go1 = true;
		String numer;
		Instruction.instruction0();
		boolean error = true;
		while (error == true) {
			try {
				if (scan.hasNextInt()) {
					numb0 = scan.nextInt();
				}
				error = false;
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		while (go0 != false) {
			switch (numb0) {
				case 0:
					go0 = false;
					break;
				case 1:
					 do {
						Instruction.instruction1();
						error = true;
						while (error == true) {
							try {
								if (scan.hasNextInt()) {
									numb1 = scan.nextInt();
								}
								error = false;
							} catch (NoSuchElementException e) {
								e.printStackTrace();
							}
						}
						switch (numb1) {
							case 0:
								go1 = false;
								break;
							case 1:
								Add.addClient();
								go1 = true;
								break;
							case 2:
								Add.addProduct();
								go1 = true;
								break;
							case 3:
								Add.addTransaction();
								go1 = true;
								break;
							case 4:
								Add.addAccount();
								go1 = true;
								break;
							default:
								go1 = true;
								break;
						}
					 }
					while (go1 != false);
					Instruction.instruction0();
					error = true;
					while (error == true) {
						try {
							if (scan.hasNextInt()) {
								numb0 = scan.nextInt();
							}
							error = false;
						} catch (NoSuchElementException e) {
							e.printStackTrace();
						}
					}
					break;
				case 2:
					Instruction.instruction2();
					numb1 = scan.nextInt();
					while (go1 != false) {
						switch (numb1) {
							case 0:
								go1 = false;
								break;
							case 1:
								;
								break;
							case 2:
								
								break;
							case 3:
								
								break;
							case 4:
								
								break;
							default:
								Instruction.instruction2();
								numb1 = scan.nextInt();
								break;
						}
						break;
					}
					Instruction.instruction0();
					error = true;
					while (error == true) {
						try {
							numb0 = scan.nextInt();
							error = false;
						} catch (NoSuchElementException e) {
							e.printStackTrace();
						}
					}
					break;
				case 3:
					Instruction.instruction3();
					numb1 = scan.nextInt();
					while (go1 != false) {
						switch (numb1) {
							case 0:
								go1 = false;
								break;
							case 1:
								
								break;
							case 2:
								
								break;
							case 3:
								
								break;
							case 4:
								
								break;
							default:
								Instruction.instruction3();
								numb1 = scan.nextInt();
								break;
						}
						break;
					}
					Instruction.instruction0();
					error = true;
					while (error == true) {
						try {
							numb0 = scan.nextInt();
							error = false;
						} catch (NoSuchElementException e) {
							e.printStackTrace();
						}
					}
					break;
				case 4:
					Instruction.instruction4();
					numb1 = scan.nextInt();
					while (go1 != false) {
						switch (numb1) {
							case 0:
								go1 = false;
								break;
							case 1:
								System.out.println("Podaj numer klienta, którego chcesz zobaczyæ.");
								numer = scan.nextLine();
								numer = scan.nextLine();
								Show.showClient(numer);
								break;
							case 2:
								
								break;
							case 3:
								
								break;
							case 4:
								
								break;
							case 5:
								Show.printAll();
								break;
							default:
								Instruction.instruction4();
								numb1 = scan.nextInt();
								break;
						}
						break;
					}
					Instruction.instruction0();
					error = true;
					while (error == true) {
						try {
							numb0 = scan.nextInt();
							error = false;
						} catch (NoSuchElementException e) {
							e.printStackTrace();
						}
					}
					break;
				default:
					Instruction.instruction0();
					error = true;
					while (error == true) {
						try {
							numb0 = scan.nextInt();
							error = false;
						} catch (NoSuchElementException e) {
							e.printStackTrace();
						}
					}
					break;
			}
		}
		System.out.println("Do widzenia!");
	}
}
