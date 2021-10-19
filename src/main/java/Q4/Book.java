package Q4;

public record Book(int id, int price) {
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
