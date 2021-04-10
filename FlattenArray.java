import java.util.*;

//
// Faltten an Array
// Input: [1,[2,[3],4],[5]]
// Output: [1,2,3,4,5] 

// [1, [2], [3]] list: [1]

// [1,  [[[[[4], 3]]]] => [1, 4, 3]

/*
input = arr
0 <= i < arr.length

first q: does it have to be ordered?
if not, I think I could use a breadth-first search type of approach where I will just go through the entire array & if it is an integer, I will add it to the list. If it is an ArrayList<Integer>() then I will add it to a Queue<List<Integer>>. And I will keep iterating over this queue until it is empty.

But since you are not online I will assume that based on the suggested pattern that you will expect it to be ordered. 

I think I could use a similar approach in this case and tackle this problem iteratively. Where I will have a main for-loop for each element in the input. Then I will check: 
* is my queue empty? if so I will check if my current index stores an integer or a list. If it is an integer I will just add it to my result. If it is a list, I will add it to my queue. So then in my next iteration, it will do:

Is my queue empty? No, so it will enter this conditional. I will poll my queue and check if it is an integer or list and either add it to my result or to my queue. Then I will repeat this continuously in a while() loop.

The issue with this solution is that I will need to be mindful of the final element, because if this stores a list then I will just be exiting the loop without solving anything. So, instead, I could swap these two logical pieces so that it is checking if the currentIndex stores an integer or a list. THEN it will check if the queue isEmpty or not in a while loop. I will do this solution first.
*/
class Main {
    public static void main(String[] args) {
        List<Object> arr = new ArrayList<>();
        arr.add(1);
        arr.add(List.of(2, List.of(4, List.of(5,6))));
        arr.add(List.of(3));
        // [1,[2,[4,[5,6]]], [3]]. Expected res: [1,2,4,5,6,3]

        Queue<List<Object>> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (Object obj : arr) {
            addElementsToQueueOrList(obj, queue, result);
            while (!queue.isEmpty()) {
                List<Object> tmp = queue.poll();
                for (Object tmpObj : tmp)
                    addElementsToQueueOrList(tmpObj, queue, result);
            }
        }

        for (Integer i :result) {
            System.out.print(i);
        }
    }

    static void addElementsToQueueOrList(
            Object obj,
            Queue<List<Object>> queue,
            List<Integer> result
    ) {
        if (obj instanceof Integer) {
            result.add((Integer) obj);
        } else {
            queue.add((List<Object>) obj);
        }
    }
}