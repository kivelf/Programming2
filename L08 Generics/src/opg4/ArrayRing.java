package opg4;


import java.util.ArrayList;

public class ArrayRing<T> implements Ring<T> {
    // the arrayList to hold the items
    private final ArrayList<T> items = new ArrayList<T>();
    // current number of items in the ring,
    // items are at index 0..size-1
    private int size;
    private int currentItemIndex;
    private T currentItem;

    /** Create an empty ring. */
    public ArrayRing(){
        size = 0;
    }

    /** ________________________________________________________ */
    @Override
    public void advance(){
        if (!isEmpty()){
            // if the current item is not the last one in the ring
            if (currentItemIndex != (size - 1)){
                currentItem = items.get(currentItemIndex + 1);
                currentItemIndex++;
            } else {
                // else the first item becomes the current item
                currentItem = items.get(0);
                currentItemIndex = 0;
            }
            // currentIndex = (current + 1) % items.size();
        }
    }

    @Override
    public T getCurrentItem(){
        try {
            if (size == 0) {
                throw new EmptyRingException("Ring is empty!");
            } else
                return currentItem;
        }
        catch (EmptyRingException ex){
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public void add(T item){
        items.add(item);
        size++;
        currentItemIndex = size - 1;
        currentItem = items.get(size - 1);
    }

    @Override
    public boolean removeItem(T item){
        if (items.contains(item)){
            if (currentItem.equals(item)) {
                removeCurrentItem();
            } else {
                // find the index of the item
                int index = 0;
                boolean found = false;
                // items.indexOf(item);
                for (int i = 0; i < size && !found; i++){
                    if (items.get(i).equals(item)){
                        index = i;
                        found = true;
                    }
                }
                // move all the remaining items one index to the left
                for (int i = index; i < size - 1; i++){
                    items.set(i, items.get(i + 1));
                }
                items.set(size - 1, null);
                size--;
            }
            return true;
        } else {
            return false;
        }
    }

    // 'member the .remove() method!!!
    @Override
    public T removeCurrentItem(){
        try {
            if (size == 0) {
                throw new EmptyRingException("Ring is empty!");
            } else {
                T removedItem = currentItem;
                // if the current item is the last item in the ring
                if (currentItemIndex == size - 1){
                    items.set(size - 1, null);
                    size--;
                    if (size != 0){
                        currentItem = items.get(0);
                        currentItemIndex = 0;
                    } else {
                        // if the removed item was the only item in the ring
                        currentItem = null;
                        currentItemIndex = 0;
                    }
                } else {
                    // updating the current item
                    items.set(currentItemIndex, items.get(currentItemIndex + 1));
                    currentItem = items.get(currentItemIndex);
                    // move all the remaining items one index to the left
                    // the new current item automatically becomes the item that was after the removed item
                    for (int i = currentItemIndex  + 1; i < size - 1; i++){
                        items.set(i, items.get(i + 1));
                    }
                    items.set(size - 1, null);
                    size--;
                }
                return removedItem;
            }
        }
        catch (EmptyRingException ex){
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        if (size == 0) return true;
        else return false;
    }

    @Override
    public String toString(){
        if (isEmpty()){
            return "Empty ring!";
        } else {
            String s = "";
            for (T t : items){
                if (t != null){
                    s += t.toString() + " ";
                }
            }
            return s;
        }
    }
}
