/**
 * A class to represents a single item of a SinglyLinkedList that can be
 * linked to other Node instances to form a list of linked nodes.
 */
class Node {
    /**
     * Constructs a new Node instance. Executed when the 'new' keyword is used.
     * @param {any} data The data to be added into this new instance of a Node.
     *    The data can be anything, just like an array can contain strings,
     *    numbers, objects, etc.
     * @returns {Node} This new Node instance is returned automatically without
     *    having to be explicitly written (implicit return).
     */
    constructor(data) {
      this.data = data;
      /**
       * This property is used to link this node to whichever node is next
       * in the list. By default, this new node is not linked to any other
       * nodes, so the setting / updating of this property will happen sometime
       * after this node is created.
       *
       * @type {Node|null}
       */
      this.next = null;
    }
  }
  
  const node1= new Node(20)
  const node2= new Node(10)
  
  /**
   * This class keeps track of the start (head) of the list and to store all the
   * functionality (methods) that each list should have.
   */
  class SinglyLinkedList {
    /**
     * Constructs a new instance of an empty linked list that inherits all the
     * methods.
     * @returns {SinglyLinkedList} The new list that is instantiated is implicitly
     *    returned without having to explicitly write "return".
     */
    constructor() {
      /** @type {Node|null} */
      this.head = null;
    }
  
    /**
     * Determines if this list is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() {
      return this.head === null;
    }
  
    /**
     * Creates a new node with the given data and inserts it at the back of
     * this list.
     * - Time: O(n) linear, n = length of list.
     * - Space: O(1) constant.
     * @param {any} data The data to be added to the new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBack(data) {
      const newBack = new Node(data);
      if (this.isEmpty()) {
        this.head = newBack;
        return this;
      }
      let runner = this.head;
      while (runner.next !== null) {
        runner = runner.next;
      }
      runner.next = newBack;
      return this;
    }
  
    /**
     * Creates a new node with the given data and inserts it at the back of
     * this list.
     * - Time: O(n) linear, n = length of list.
     * - Space: O(n) linear due to the call stack.
     * @param {any} data The data to be added to the new node.
     * @param {?Node} runner The current node during the traversal of this list
     *    or null when the end of the list has been reached.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBackRecursive(data, runner = this.head) {
      if (this.isEmpty()) {
        this.head = new Node(data);
        return this;
      }
      if (runner.next === null) {
        runner.next = new Node(data);
        return this;
      }
      return this.insertAtBackRecursive(data, runner.next);
    }
  
    /**
     * Calls insertAtBack on each item of the given array.
     * - Time: O(n * m) n = list length, m = arr.length.
     * - Space: O(1) constant.
     * @param {Array<any>} vals The data for each new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBackMany(vals) {
      for (const item of vals) {
        this.insertAtBack(item);
      }
      return this;
    }
  
    /**
     * Converts this list into an array containing the data of each node.
     * - Time: O(n) linear.
     * - Space: O(n).
     * @returns {Array<any>} An array of each node's data.
     */
    toArr() {
      //create an empty array to store the result
      const arr = [];
      //create a variable initialized to the head of the singly linked list
      let runner = this.head;
  
      //loop while the current node is not null
      while (runner) {
        //push the data of the current node to the result array
        arr.push(runner.data);
        //move the current node to its next node
        runner = runner.next;
      }
      //return the result array
      return arr;
    }
  
    /**
     * Determines the length of this list.
     * - Time: O(n) linear, n = length of list
     * - Space: O(1) constant
     * @returns {number} The length.
     */
    length() {
      let runner = this.head;
      let count = 0;
      while (runner) {
        count++;
        runner = runner.next;
      }
      return count;
    }
  
    /**
     * Creates a new node with the given data and inserts that node at the front
     * of this list.
     * - Time: (?).
     * - Space: (?).
     * @param {any} data The data for the new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtFront(data) {
      const newNode = new Node(data);
      newNode.next = this.head;
      this.head = newNode;
      return this;
    }
  
    /**
     * Removes the first node of this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {any} The data from the removed node.
     */
    removeHead() {
      if (this.isEmpty()) {
        return null;
      }
      const temp = this.head;
      this.head = this.head.next;
      return temp.data;
    }
  
    // EXTRA
    /**
     * Calculates the average of this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {number|NaN} The average of the node's data.
     */
    average() {
      let runner = this.head;
      let sum = 0;
      let count = 0;
      while (runner) {
        sum += runner.data;
        count++;
        runner = runner.next;
      }
      return sum / count;
    }
  
    // TODO
    /**
     * Removes the last node of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {any} The data from the node that was removed.
     */
    removeBack() {
      //TODO: your code here
      let runner = this.head 
      if (this.isEmpty()){
        return null
      }
      if (this.length()==1){
        return this.removeHead()
      }
      else {
        while (runner.next.next) {
          runner = runner.next
        }
        let removed = runner.next.data;
        runner.next = null
        return removed
      }
    }
  
    /**
     * Determines whether or not the given search value exists in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} val The data to search for in the nodes of this list.
     * @returns {boolean}
     */
    contains(val) {
      //TODO: your code here
      // create a variable initialized to the head of the list
      // while the created variable is not null, loop inside the list
        // check if the data of the variable is equal to the given value, than return true 
        // else set the variable to its next node
      // if the loop reach the end and we didn't found the value so wa are going to return false
    }
  
    /**
     * Determines whether or not the given search value exists in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} val The data to search for in the nodes of this list.
     * @param {?ListNode} current The current node during the traversal of this list
     *    or null when the end of the list has been reached.
     * @returns {boolean}
     */
    containsRecursive(val, current = this.head) {
      //TODO: your code here
      // check if the current variable is null, return false
      // check if the data of the current variable is equal to the given value, return true
      // if the two conditions are not satisfied, invoke the current function with the same given value and the next of the current node as parameters
    }
  
    // EXTRA
    /**
     * Recursively finds the maximum integer data of the nodes in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {ListNode} runner The start or current node during traversal, or null
     *    when the end of the list is reached.
     * @param {ListNode} maxNode Keeps track of the node that contains the current
     *    max integer as it's data.
     * @returns {?number} The max int or null if none.
     */
    recursiveMax(runner = this.head, maxNode = this.head) {
      //TODO: your code here
      // check if the list is empty, return null
      // check if the runner is null, return the data of the maximum node
      // check if the data of the runner is greater than the data of the maximum node, the maximum node would be updated to the runner
      // after finishing these tests, return the same function with the next node of the runner and the maximum node as parameters
    }
  }
  // Testing the functions
  const testList = new SinglyLinkedList().insertAtBackMany([10, 20, 30, 40]);
  
  console.log("Initial List:", testList.toArr());
  
  // Test removeBack
  const removedBack = testList.removeBack();
  console.log("After removeBack():", testList.toArr(), "| Removed back data:", removedBack);
  
  // Test contains
  // const contains30 = testList.contains(30);
  // console.log("Contains 30:", contains30);
  
  // const contains50 = testList.contains(50);
  // console.log("Contains 50:", contains50);
  
  // // Test containsRecursive
  // const containsRecursive30 = testList.containsRecursive(30);
  // console.log("Contains Recursive 30:", containsRecursive30);
  
  // const containsRecursive50 = testList.containsRecursive(50);
  // console.log("Contains Recursive 50:", containsRecursive50);
  
  // // Test recursiveMax
  // const maxVal = testList.recursiveMax();
  // console.log("Max value in list:", maxVal);
  
  // // Additional case: Empty list
  // const emptyList = new SinglyLinkedList();
  // console.log("Empty List:", emptyList.toArr());
  // console.log("Max value in empty list:", emptyList.recursiveMax());
  // console.log("Contains 10 in empty list:", emptyList.contains(10));
  // console.log("Contains Recursive 10 in empty list:", emptyList.containsRecursive(10));
  // console.log("Remove back from empty list:", emptyList.removeBack());