import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("\nWelcome!");
            Scanner in = new Scanner(System.in);
            Scanner ln = new Scanner(System.in);
            int choice;
            char ch = 'y';
            while (ch == 'y' || ch == 'Y') {
                System.out.println("\nChoose a way to work:");
                System.out.println("1. Work with phone.");
                System.out.println("2. Work with triangle.");
                System.out.println("3. Work with point.");
                System.out.print("Your choice: ");
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        WorkWithPhone();
                        break;
                    case 2:
                        WorkWithTriangle();
                        break;
                    case 3:
                        WorkWithPoint();
                        break;
                    default:
                        System.out.println("\nInvalid data.");
                        break;
                }
                System.out.print("\nIf you want to choose another way to work, press 'Y', if you don't - press any key: ");
                ch = ln.next().charAt(0);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Functions for work with Phone
    private static void WorkWithPhone() throws Exception {
        Scanner in = new Scanner(System.in);
        Scanner ln = new Scanner(System.in);
        Scanner nt = new Scanner(System.in);
        System.out.print("\nEnter quantity of objects: ");
        int quantity = in.nextInt();
        if (quantity <= 0) throw new Exception("\nInvalid data.");
        String name, sureName, middleName, address, numberOfCreditCard;
        int debit, credit, urbanConv, longDistConv;
        ArrayList<Phone> array = new ArrayList<Phone>();
        for(int i = 0; i < quantity; i++) {
            if (quantity != 1) System.out.println("\nEnter data of the " + (i + 1) + " subscriber:");
            else System.out.println("\nEnter the subscriber data:");
            System.out.print("SureName: ");
            sureName = nt.next();
            System.out.print("Name: ");
            name = nt.next();
            System.out.print("MiddleName: ");
            middleName = nt.next();
            System.out.print("Address: ");
            address = ln.nextLine();
            System.out.print("Number of Credit card: ");
            numberOfCreditCard = ln.nextLine();
            System.out.print("Debit ($): ");
            debit = in.nextInt();
            System.out.print("Credit ($): ");
            credit = in.nextInt();
            System.out.print("Urban conversation (minutes): ");
            urbanConv = in.nextInt();
            System.out.print("Long-distance conversation (minutes): ");
            longDistConv = in.nextInt();
            array.add(new Phone(name, sureName, middleName, address,
                    numberOfCreditCard, debit, credit, urbanConv, longDistConv));
        }
        int choice;
        char ch = 'y';
        while(ch == 'y' || ch == 'Y') {
            System.out.println("\nChoose what you want to do: ");
            System.out.println("1. Display information about subscribers who have more than the specified time for urban conversation.");
            System.out.println("2. Display information about subscribers who used long-distance communication.");
            System.out.println("3. Display information about subscribers in alphabetical order.");
            System.out.print("Your choice: ");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter minutes of urban conversation: ");
                    int number = in.nextInt();
                    System.out.println();
                    getPhoneWithUrbanConv(array, number);
                    break;
                case 2:
                    System.out.println();
                    getPhoneWithLongDistConv(array);
                    break;
                case 3:
                    System.out.println();
                    getPhoneWithAlphabeticalOrder(array);
                    break;
                default:
                    System.out.println("\nInvalid data.");
                    break;
            }
            System.out.print("\n\nIf you want to continue, press 'Y', if you don't - press any key: ");
            ch = nt.next().charAt(0);
        }
    }

    public static void getPhoneWithUrbanConv(ArrayList<Phone> array, int urbanConv) {
        int counter = 0;
        System.out.printf("%12s%12s%17s%19s%25s%13s%14s%15s%23s", "SureName", "Name", "MiddleName",
                "Address", "Number of Credit card", "Debit ($)", "Credit ($)", "Urban conv.",
                "Long-distance conv.");
        for(int i = 0; i < array.size(); i++)
            if(array.get(i).getUrbanConv() > urbanConv) {
                System.out.println();
                array.get(i).Show();
                counter++;
            }
        if (counter == 0) System.out.print("\nThere are no such subscribers.");
    }
    public static void getPhoneWithLongDistConv(ArrayList<Phone> array) {
        int counter = 0;
        System.out.printf("%12s%12s%17s%19s%25s%13s%14s%15s%23s", "SureName", "Name", "MiddleName",
                "Address", "Number of Credit card", "Debit ($)", "Credit ($)", "Urban conv.",
                "Long-distance conv.");
        for(int i = 0; i < array.size(); i++)
            if(array.get(i).getLongDistConv() > 0) {
                System.out.println();
                array.get(i).Show();
                counter++;
            }
        if (counter == 0) System.out.print("\nThere are no such subscribers.");
    }
    public static void getPhoneWithAlphabeticalOrder(ArrayList<Phone> array) {
        ArrayList<String> alphabet = new ArrayList<String>(array.size());
        for(int i = 0; i < array.size(); i++)
            alphabet.add(i,array.get(i).getSureName());
        Collections.sort(alphabet);
        System.out.printf("%12s%12s%17s%19s%25s%13s%14s%15s%23s", "SureName", "Name", "MiddleName",
                "Address", "Number of Credit card", "Debit ($)", "Credit ($)", "Urban conv.",
                "Long-distance conv.");
        for(int i = 0; i < array.size(); i++)
            for(int j = 0; j < array.size(); j++)
                if(alphabet.get(i) == array.get(j).getSureName()) {
                    System.out.println();
                    array.get(j).Show();
                    break;
                }
    }

    // Functions for work with Triangle
    private static void WorkWithTriangle() throws Exception {
        Scanner in = new Scanner(System.in);
        Scanner nt = new Scanner(System.in);
        int choice, AB, BC, AC, quantity;
        char ch = 'y';
        ArrayList<Triangle> array = new ArrayList<Triangle>();
        ArrayList<Triangle> equilateral = new ArrayList<Triangle>(); //равносторонний
        ArrayList<Triangle> isosceles = new ArrayList<Triangle>();   //равнобедренный
        ArrayList<Triangle> rectangular = new ArrayList<Triangle>(); //прямоугольный
        ArrayList<Triangle> arbitrary = new ArrayList<Triangle>();   //произвольный
        while (ch == 'y') {
            System.out.println("\nChoose a way to work:");
            System.out.println("1. Work with one triangle.");
            System.out.println("2. Work with array of triangles.");
            System.out.print("Your choice: ");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter AB: ");
                    AB = in.nextInt();
                    System.out.print("Enter BC: ");
                    BC = in.nextInt();
                    System.out.print("Enter AC: ");
                    AC = in.nextInt();
                    Triangle triangle = new Triangle(AB, BC, AC);
                    triangle.Show();
                    break;
                case 2:
                    System.out.print("\nEnter quantity of triangles: ");
                    quantity = in.nextInt();
                    for(int i = 0; i < quantity; i++) {
                        System.out.println("\nEnter data of the " + (i + 1) + " triangle:");
                        System.out.print("Enter AB: ");
                        AB = in.nextInt();
                        System.out.print("Enter BC: ");
                        BC = in.nextInt();
                        System.out.print("Enter AC: ");
                        AC = in.nextInt();
                        array.add(new Triangle(AB, BC, AC));
                    }
                    quantityOfDifferentType(array, equilateral, isosceles, rectangular, arbitrary);
                    biggerAndLesser(equilateral, isosceles, rectangular, arbitrary);
                    equilateral.clear();
                    isosceles.clear();
                    rectangular.clear();
                    arbitrary.clear();
                    array.clear();
                    break;
                default:
                    System.out.println("\nInvalid data.");
                    break;
            }
            System.out.print("\nIf you want to continue, press 'Y', if you don't - press any key: ");
            ch = nt.next().charAt(0);
        }
    }

    public static void quantityOfDifferentType(ArrayList<Triangle> array, ArrayList<Triangle> equilateral,
                                               ArrayList<Triangle> isosceles, ArrayList<Triangle> rectangular,
                                               ArrayList<Triangle> arbitrary) {
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i).isEquilateral())
                equilateral.add(array.get(i));
            else if(array.get(i).isIsosceles())
                isosceles.add(array.get(i));
            else if(array.get(i).isRectangular())
                rectangular.add(array.get(i));
            else
                arbitrary.add(array.get(i));
        }
        System.out.println("\nQuantity of Equilateral triangles = " + equilateral.size());
        System.out.println("Quantity of Isosceles triangles = " + isosceles.size());
        System.out.println("Quantity of Rectangular triangles = " + rectangular.size());
        System.out.println("Quantity of Arbitrary triangles = " + arbitrary.size());

    }
    public static void biggerAndLesser(ArrayList<Triangle> equilateral, ArrayList<Triangle> isosceles,
                                       ArrayList<Triangle> rectangular, ArrayList<Triangle> arbitrary) {
        int eMax = 0, iMax = 0, rMax = 0, aMax = 0, eMin = 0, iMin = 0, rMin = 0, aMin = 0;
        int e1Max = 0, i1Max = 0, r1Max = 0, a1Max = 0, e1Min = 0, i1Min = 0, r1Min = 0, a1Min = 0;
        double minSquare = 0, maxSquare = 0;
        for(int i = 0, maxPer = 0, minPer = 0; i < equilateral.size(); i++) {
            if(i == 0) {
                minSquare = maxSquare = equilateral.get(i).square();
                minPer = maxPer = equilateral.get(i).perimeter();
                continue;
            }
            if(equilateral.get(i).perimeter() < minPer) {
                minPer = equilateral.get(i).perimeter();
                eMin = i;
            }
            else if(equilateral.get(i).perimeter() > maxPer) {
                maxPer = equilateral.get(i).perimeter();
                eMax = i;
            }
            if(equilateral.get(i).square() < minSquare) {
                minSquare = equilateral.get(i).square();
                e1Min = i;
            }
            else if(equilateral.get(i).square() > maxSquare) {
                maxSquare = equilateral.get(i).square();
                e1Max = i;
            }
        }
        for(int i = 0, maxPer = 0, minPer = 0; i < isosceles.size(); i++) {
            if(i == 0) {
                minSquare = maxSquare = isosceles.get(i).square();
                minPer = maxPer = isosceles.get(i).perimeter();
                continue;
            }
            if(isosceles.get(i).perimeter() < minPer) {
                minPer = isosceles.get(i).perimeter();
                iMin = i;
            }
            else if(isosceles.get(i).perimeter() > maxPer) {
                maxPer = isosceles.get(i).perimeter();
                iMax = i;
            }
            if(isosceles.get(i).square() < minSquare) {
                minSquare = isosceles.get(i).square();
                i1Min = i;
            }
            else if(isosceles.get(i).square() > maxSquare) {
                maxSquare = isosceles.get(i).square();
                i1Max = i;
            }
        }
        for(int i = 0, maxPer = 0, minPer = 0; i < rectangular.size(); i++) {
            if(i == 0) {
                minSquare = maxSquare = rectangular.get(i).square();
                minPer = maxPer = rectangular.get(i).perimeter();
                continue;
            }
            if(rectangular.get(i).perimeter() < minPer) {
                minPer = rectangular.get(i).perimeter();
                rMin = i;
            }
            else if(rectangular.get(i).perimeter() > maxPer) {
                maxPer = rectangular.get(i).perimeter();
                rMax = i;
            }
            if(rectangular.get(i).square() < minSquare) {
                minSquare = rectangular.get(i).square();
                r1Min = i;
            }
            else if(rectangular.get(i).square() > maxSquare) {
                maxSquare = rectangular.get(i).square();
                r1Max = i;
            }
        }
        for(int i = 0, maxPer = 0, minPer = 0; i < arbitrary.size(); i++) {
            if(i == 0) {
                minSquare = maxSquare = arbitrary.get(i).square();
                minPer = maxPer = arbitrary.get(i).perimeter();
                continue;
            }
            if(arbitrary.get(i).perimeter() < minPer) {
                minPer = arbitrary.get(i).perimeter();
                aMin = i;
            }
            else if(arbitrary.get(i).perimeter() > maxPer) {
                maxPer = arbitrary.get(i).perimeter();
                aMax = i;
            }
            if(arbitrary.get(i).square() < minSquare) {
                minSquare = arbitrary.get(i).square();
                a1Min = i;
            }
            else if(arbitrary.get(i).square() > maxSquare) {
                maxSquare = arbitrary.get(i).square();
                a1Max = i;
            }
        }
        if(equilateral.size() != 0) {
            System.out.println("\nEquilaterals triangles:");
            System.out.println("Min square: " + equilateral.get(e1Min).square());
            System.out.println("Max square: " + equilateral.get(e1Max).square());
            System.out.println("Min perimeter: " + equilateral.get(eMin).perimeter());
            System.out.println("Max perimeter: " + equilateral.get(eMax).perimeter());
        }
        if(isosceles.size() != 0) {
            System.out.println("\nIsosceles triangles:");
            System.out.println("Min square: " + isosceles.get(i1Min).square());
            System.out.println("Max square: " + isosceles.get(i1Max).square());
            System.out.println("Min perimeter: " + isosceles.get(iMin).perimeter());
            System.out.println("Max perimeter: " + isosceles.get(iMax).perimeter());
        }
        if(rectangular.size() != 0) {
            System.out.println("\nRectangular triangles:");
            System.out.println("Min square: " + rectangular.get(r1Min).square());
            System.out.println("Max square: " + rectangular.get(r1Max).square());
            System.out.println("Min perimeter: " + rectangular.get(rMin).perimeter());
            System.out.println("Max perimeter: " + rectangular.get(rMax).perimeter());
        }
        if(arbitrary.size() != 0) {
            System.out.println("\nArbitrary triangles:");
            System.out.println("Min square: " + arbitrary.get(a1Min).square());
            System.out.println("Max square: " + arbitrary.get(a1Max).square());
            System.out.println("Min perimeter: " + arbitrary.get(aMin).perimeter());
            System.out.println("Max perimeter: " + arbitrary.get(aMax).perimeter());
        }
    }

    // Functions for work with Point
    private static void WorkWithPoint() throws Exception {
        Scanner in = new Scanner(System.in);
        Scanner nt = new Scanner(System.in);
        int choice, numerator, denominator;
        char ch = 'y';
        RationalFraction x = new RationalFraction();
        RationalFraction y = new RationalFraction();
        RationalFraction z = new RationalFraction();
        Point A = new Point();
        Point B = new Point();
        Point C = new Point();
        for(int i = 0; i < 3; i++) {
            if(i == 0) System.out.println("\nEnter coordinates of point A:");
            else if(i == 1) System.out.println("\nEnter coordinates of point B:");
            else System.out.println("\nEnter coordinates of point C:");
            System.out.println("Coordinate x: ");
            System.out.print("Numerator = ");
            numerator = in.nextInt();
            System.out.print("Denominator = ");
            denominator = in.nextInt();
            x.setNumerator(numerator);
            x.setDenominator(denominator);
            System.out.println("Coordinate y: ");
            System.out.print("Numerator = ");
            numerator = in.nextInt();
            System.out.print("Denominator = ");
            denominator = in.nextInt();
            y.setNumerator(numerator);
            y.setDenominator(denominator);
            System.out.println("Coordinate z: ");
            System.out.print("Numerator = ");
            numerator = in.nextInt();
            System.out.print("Denominator = ");
            denominator = in.nextInt();
            z.setNumerator(numerator);
            z.setDenominator(denominator);
            if(i == 0) {
                A.setX(x);
                A.setY(y);
                A.setZ(z);
            }
            else if(i == 1) {
                B.setX(x);
                B.setY(y);
                B.setZ(z);
            }
            else {
                C.setX(x);
                C.setY(y);
                C.setZ(z);
            }
        }
        while(ch == 'y') {
            System.out.println("\nChoose what you want to do: ");
            System.out.println("1. Display distance between points.");
            System.out.println("2. Display distance between points and point O(0,0,0).");
            System.out.println("3. Determine whether these points lie on the same straight line.");
            System.out.print("Your choice: ");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nDistance between A and B = " + A.DistanceBetweenPoint(B));
                    System.out.println("Distance between A and C = " + A.DistanceBetweenPoint(C));
                    System.out.println("Distance between B and C = " + B.DistanceBetweenPoint(C));
                    break;
                case 2:
                    System.out.println("\nDistance between A and O = " + A.DistanceBetweenO());
                    System.out.println("Distance between B and O = " + B.DistanceBetweenO());
                    System.out.println("Distance between C and O = " + C.DistanceBetweenO());
                    break;
                case 3:
                    if(onLine(A, B, C)) System.out.println("\nThese points lie on the same straight line.");
                    else System.out.println("\nThese points don't lie on the same straight line.");
                    break;
                default:
                    System.out.println("\nInvalid data.");
                    break;
            }
            System.out.print("\nIf you want to continue, press 'Y', if you don't - press any key: ");
            ch = nt.next().charAt(0);
        }
    }

    public static boolean onLine(Point point1, Point point2, Point point3) {
        double X1, X2, Y1, Y2, Z1, Z2;

        X1 = point2.coordX() - point1.coordX();
        Y1 = point2.coordY() - point1.coordY();
        Z1 = point2.coordZ() - point1.coordZ();

        X2 = point3.coordX() - point1.coordX();
        Y2 = point3.coordY() - point1.coordY();
        Z2 = point3.coordZ() - point1.coordZ();

        if ((X1 == 0 && Y1 == 0 && Z1 == 0) || (X2 == 0 && Y2 == 0 && Z2 == 0)) return true;
        else if (X1 != 0 && (Z1 * (X2 / X1) == Z2) && (Y1 * (X2 / X1) == Y2)) return true;
        else if (X2 != 0 && (Z2 * (X1 / X2) == Z1) && (Y2 * (X1 / X2) == Y1)) return true;
        else if (Y1 != 0 && (X1 * (Y2 / Y1) == X2) && (Z1 * (Y2 / Y1) == Z2)) return true;
        else if (Y2 != 0 && (X2 * (Y1 / Y2) == X1) && (Z2 * (Y1 / Y2) == Z1)) return true;
        else if (Z1 != 0 && (X1 * (Z2 / Z1) == X2) && (Y1 * (Z2 / Z1) == Y2)) return true;
        else if (Z2 != 0 && (X2 * (Z1 / Z2) == X1) && (Y2 * (Z1 / Z2) == Y1)) return true;
        return false;
    }
}