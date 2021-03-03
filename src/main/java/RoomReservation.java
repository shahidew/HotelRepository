public class RoomReservation {
    private String name;
    private String family;
    private int nationalCode;
    private String startDate;
    private String endDate;
    private int capacity;
    private int reserveCode;

    public RoomReservation(String name, String family, int nationalCode, String startDate, String endDate, int capacity, int reserveCode) {
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.reserveCode = reserveCode;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getReserveCode() {
        return reserveCode;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getReserveCode() {
        return reserveCode;
    }

    public void setReserveCode(int reserveCode) {
        this.reserveCode = reserveCode;
    }*/
}
