package Array;

import java.util.Arrays;

public class Array {
    private int[] data; // mảng lưu dữ liệu
    private int size; // số phần tử hiện có

    // =================== CONSTRUCTOR ===================
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10); // mặc định dung lượng 10
    }

    // =================== THÊM PHẦN TỬ ===================

    // Thêm phần tử ở đầu mảng
    public void addFirst(int value) {
        addMiddle(value, 0);
    }

    // Thêm phần tử ở cuối mảng
    public void addLast(int value) {
        ensureCapacity();
        data[size++] = value;
    }

    // Thêm phần tử ở vị trí bất kỳ
    public void addMiddle(int value, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        ensureCapacity();

        // Dời các phần tử sang phải để chừa chỗ
        for (int i = size; i > position; i--) {
            data[i] = data[i - 1];
        }

        data[position] = value;
        size++;
    }

    // =================== XÓA PHẦN TỬ ===================

    // Xóa phần tử đầu tiên
    public void removeFirst() {
        removeMiddle(0);
    }

    // Xóa phần tử cuối cùng
    public void removeLast() {
        if (size == 0)
            throw new IllegalStateException("Array is empty");
        size--;
    }

    // Xóa phần tử ở vị trí bất kỳ
    public void removeMiddle(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        for (int i = position; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    // =================== HỖ TRỢ ===================

    // Kiểm tra và mở rộng dung lượng nếu cần
    private void ensureCapacity() {
        if (size >= data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    // Lấy giá trị tại vị trí bất kỳ
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        return data[index];
    }

    // Cập nhật giá trị tại vị trí bất kỳ
    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        data[index] = value;
    }

    // Lấy số phần tử hiện có
    public int size() {
        return size;
    }

    // In toàn bộ mảng
    public void print() {
        System.out.print("Array = [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1)
                System.out.print(", ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.addLast(10);
        array.addLast(12);
        array.addLast(7);
        array.addLast(4);
        array.addLast(16);
        array.addLast(2);
        array.print();
        array.removeMiddle(3);
        array.print();
    }
}
