public class WorkSpace implements Comparable<WorkSpace>, WorkSpaceService{

    private int number;
    private String type;
    private boolean isAvailable;

    public WorkSpace(int number, String type, boolean isAvailable) {
        this.number = number;
        this.type = type;
        this.isAvailable = isAvailable;
    }

    @Override
    public int compareTo(WorkSpace o) {
        return Integer.compare(this.number, o.number);
    }


    @Override
    public void markAsBooked() {
        if (!isAvailable) {
            throw new WorkspaceNotAvailableException("Место " + number + " уже занято!");
        }
        isAvailable = false;
        System.out.println("Место " + number + " успешно забронировано!");
    }

    @Override
    public void markAsAvailable() {
        isAvailable = true;
        System.out.println("Место " + number + " свободно!");
    }

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return " [ Место № " + getNumber() + " - " + " Тип : " + getType() + " - " + " Статус : " + isAvailable() + " ]";
    }
}
