package assignment4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Assignment4Test {
    @Test void intStackWorks() { IntStack stack = new IntStack(2); assertTrue(stack.push(10)); assertTrue(stack.push(20)); assertTrue(stack.isFull()); assertEquals(20, stack.pop()); assertEquals(10, stack.peek()); }
    @Test void queueWorks() { IntQueue queue = new IntQueue(2); assertTrue(queue.enqueue(10)); assertTrue(queue.enqueue(20)); assertTrue(queue.isFull()); assertEquals(10, queue.dequeue()); assertEquals(20, queue.peek()); }
    @Test void linkedListWorks() { LinkedList<String> list = new LinkedList<>(); list.addFirst("b"); list.addFirst("a"); list.addLast("d"); list.insert(2, "c"); assertEquals("b", list.delete(1)); assertEquals(3, list.size()); Iterator<String> iterator = list.iterator(); assertEquals("a", iterator.next()); assertEquals("c", iterator.next()); assertEquals("d", iterator.next()); assertFalse(iterator.hasNext()); }
    @Test void genericStackWorks() { Stack<Employee> stack = new Stack<>(2); Employee employee = new Employee(1, "Shreya"); assertTrue(stack.push(employee)); assertEquals(employee, stack.peek()); assertEquals(employee, stack.pop()); assertTrue(stack.isEmpty()); }
    @Test void bracketsAreChecked() { assertTrue(BracketChecker.isValid("[{a+b} * (c-d)]")); assertFalse(BracketChecker.isValid("[((a-b} * (c-d)]]]")); }
}
