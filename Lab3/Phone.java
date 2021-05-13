public class Phone {

    private String name;
    private String sureName;
    private String middleName;
    private String address;
    private String numberOfCreditCard;
    private int debit;
    private int credit;
    private int urbanConv;
    private int longDistConv;

    public Phone() {
        name = sureName = middleName = address = numberOfCreditCard = "";
        debit = credit = urbanConv = longDistConv = 0;
    }
    public Phone(String name, String sureName, String middleName,
                 String address, String numberOfCreditCard, int debit,
                 int credit, int urbanConv, int longDistConv)  throws Exception {
        setName(name);
        setSureName(sureName);
        setMiddleName(middleName);
        setAddress(address);
        setNumberOfCreditCard(numberOfCreditCard);
        setDebit(debit);
        setCredit(credit);
        setUrbanConv(urbanConv);
        setLongDistConv(longDistConv);
    }

    public void setName(String name) { this.name = name; }
    public void setSureName(String sureName) { this.sureName = sureName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setAddress(String address) { this.address = address; }
    public void setNumberOfCreditCard(String numberOfCreditCard) throws Exception {
        for(int i = 0; i < numberOfCreditCard.length(); i++)
            if((numberOfCreditCard.charAt(i) < 48 || numberOfCreditCard.charAt(i) > 57) && numberOfCreditCard.charAt(i) != 32)
                throw new Exception("\nInvalid data. The number of credit card consist of only numbers or spaces.\n");
        this.numberOfCreditCard = numberOfCreditCard;
    }
    public void setDebit(int debit) throws Exception {
        if(debit < 0) throw new Exception("\nInvalid data. Debit can't be less than 0.\n");
        this.debit = debit;
    }
    public void setCredit(int credit) throws Exception {
        if(credit < 0)
            throw new Exception("\nInvalid data. Credit can't be less than 0.\n");
        this.credit = credit;
    }
    public void setUrbanConv(int urbanConv) throws Exception {
        if(urbanConv < 0)
            throw new Exception("\nInvalid data. Urban conversations can't be less than 0.\n");
        this.urbanConv = urbanConv;
    }
    public void setLongDistConv(int longDistConv) throws Exception {
        if(longDistConv < 0)
            throw new Exception("\nInvalid data. Long-distance conversations can't be less than 0.\n");
        this.longDistConv = longDistConv;
    }

    public String getName() { return this.name; }
    public String getSureName() { return this.sureName; }
    public String getMiddleName() { return this.middleName; }
    public String getAddress() { return this.address; }
    public String getNumberOfCreditCard() { return this.numberOfCreditCard; }
    public int getDebit() { return this.debit; }
    public int getCredit() { return this.credit; }
    public int getUrbanConv() { return this.urbanConv; }
    public int getLongDistConv() { return this.longDistConv; }

    public String toString() {
        return "Name: " + this.name + ".\n" +
                "Surname: " + this.sureName + ".\n" +
                "Middle name: " + this.middleName + ".\n" +
                "Address: " + this.address + ".\n" +
                "Number of credit card: " + this.numberOfCreditCard + ".\n" +
                "Debit: " + this.debit + ".\n" +
                "Credit: " + this.credit + ".\n" +
                "Time of urban conversations: " + this.urbanConv + ".\n" +
                "Time of long-distance conversations: " + this.longDistConv + ".";
    }

    public void Show() {
        System.out.printf("%12s%12s%17s%19s%25s%12s%14s%15s%23s", this.sureName, this.name, this.middleName,
                this.address, this.numberOfCreditCard, this.debit, this.credit, this.urbanConv,
                this.longDistConv);
//        System.out.println("Name: " + this.name + ".");
//        System.out.println("Surname: " + this.sureName + ".");
//        System.out.println("Middle name: " + this.middleName + ".");
//        System.out.println("Address: " + this.address + ".");
//        System.out.println("Number of credit card: " + this.numberOfCreditCard + ".");
//        System.out.println("Debit: " + this.debit + ".");
//        System.out.println("Credit: " + this.credit + ".");
//        System.out.println("Time of urban conversations: " + this.urbanConv + ".");
//        System.out.println("Time of long-distance conversations: " + this.longDistConv + ".");
    }
}