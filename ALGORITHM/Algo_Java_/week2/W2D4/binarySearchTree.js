//? resources: https://www.geeksforgeeks.org/binary-search-tree-data-structure/
/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
class BSTNode {
    /**
     * Constructs a new instance of a BST node.
     * @param {number} data The integer to store in the node.
     */
    constructor(data) {
      this.data = data;
      /**
       * These properties are how this node is connected to other nodes to form
       * the tree. Similar to .next in a SinglyLinkedList except a BST node can
       * be connected to two other nodes. To start, new nodes will not be
       * connected to any other nodes, these properties will be set after
       * the new node is instantiated.
       *
       * @type {BSTNode|null}
       */
      this.left = null;
      /** @type {BSTNode|null} */
      this.right = null;
    }
  }
  
  /**
   * Represents an ordered tree of nodes where the data of left nodes are <= to
   * their parent and the data of nodes to the right are > their parent's data.
   */
  class BinarySearchTree {
    constructor() {
      /**
       * Just like the head of a linked list, this is the start of our tree which
       * branches downward from here.
       *
       * @type {BSTNode|null}
       */
      this.root = null;
    }
  
    /**
     * Determines if this tree is empty.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {boolean} Indicates if this tree is empty.
     */
    isEmpty() {
      return this.root === null;
    }
  
    /**
     * Retrieves the smallest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    min(current = this.root) {
      if (current === null) {
        return null;
      }
      while (current.left != null) {
        current = current.left;
      }
      return current.data;
    }
  
    /**
     * Retrieves the smallest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    minRecursive(current = this.root) {
      if (current === null) {
        return null;
      }
      if (current.left != null) {
        current = current.left;
        return this.minRecursive(current);
      }
      return current.data;
    }
  
    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    max(current = this.root) {
      if (current === null) {
        return null;
      }
      while (current.right != null) {
        current = current.right;
      }
      return current.data;
    }
  
    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    maxRecursive(current = this.root) {
      if (current === null) {
        return null;
      }
      if (current.right != null) {
        current = current.right;
        return this.maxRecursive(current);
      }
      return current.data;
    }
  
    /**
     * Determines if this tree contains the given searchVal.
     * - Time: O(?).
     * - Space: O(?).
     * @param {number} searchVal The number to search for in the node's data.
     * @returns {boolean} Indicates if the searchVal was found.
     */
    contains(searchVal) {
      let current = this.root;
      while (current != null) {
        if (current.data == searchVal) {
          return true;
        } else {
          if (current.data > searchVal) {
            current = current.left;
          } else {
            current = current.right;
          }
        }
      }
      return false;
    }
  
    /**
     * Determines if this tree contains the given searchVal.
     * - Time: O(?).
     * - Space: O(?).
     * @param {number} searchVal The number to search for in the node's data.
     * @returns {boolean} Indicates if the searchVal was found.
     */
    containsRecursive(searchVal, current = this.root) {
      if (current == null) {
        return false;
      }
      if (current.data == searchVal) {
        return true;
      }
      if (current.data > searchVal) {
        return this.containsRecursive(searchVal, current.left);
      } else {
        return this.containsRecursive(searchVal, current.right);
      }
    }
  
    /**
     * Calculates the range (max - min) from the given startNode.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} startNode The node to start from to calculate the range.
     * @returns {number|null} The range of this tree or a sub tree depending on if the
     *    startNode is the root or not.
     */
    range(startNode = this.root) {
      if (!startNode) {
        return null;
      } else {
        return this.max(startNode) - this.min(startNode);
      }
    }
  
    //TODO
    /**
     * Inserts a new node with the given newVal in the right place to preserver
     * the order of this tree.
     * - Time: O(h) linear, h = height of tree because the new node may have to
     *    be added at the bottom.
     * - Space: O(1) constant.
     * @param {number} newVal The data to be added to a new node.
     * @returns {BinarySearchTree} This tree.
     */
    insert(newVal) {
      //TODO: your code here
      const node = new BSTNode(newVal)
      if(this.isEmpty()){
        this.root= node
        return this
      }
      let current = this.root
      while(true){
        if(newVal <= current.data){
          if(current.left === null){
            current.left = node
            return this
          }else{
            current = current.left
          }
        }else{
          if(current.right === null){
            current.right = node 
            return this
          }
          current=current.right
        }
      }
    }
  
    /**
     * Inserts a new node with the given newVal in the right place to preserver
     * the order of this tree.
     * - Time: O(h) linear, h = height of tree because the new node may have to
     *    be added at the bottom.
     * - Space: O(h) linear due to the call stack.
     * @param {number} newVal The data to be added to a new node.
     * @param {BSTNode} curr The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {BinarySearchTree} This tree.
     */
    insertRecursive(newVal, current = this.root) {
      //TODO: your code here
    }
  
    // Logs this tree horizontally with the root on the left.
    print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
      if (!node) {
        return;
      }
  
      spaceCnt += spaceIncr;
      this.print(node.right, spaceCnt);
  
      console.log(
        " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
          `${node.data}`
      );
  
      this.print(node.left, spaceCnt);
    }
  }
  
  // const emptyTree = new BinarySearchTree();
  // const oneNodeTree = new BinarySearchTree();
  // oneNodeTree.root = new BSTNode(10);
  // oneNodeTree.print()
  // console.log("min of one node tree: ", oneNodeTree.min());
  // console.log("max of one node tree: ", oneNodeTree.max());
  // /* twoLevelTree
  //         root
  //         10
  //       /   \
  //     5     15
  // */
  // const twoLevelTree = new BinarySearchTree();
  // twoLevelTree.root = new BSTNode(10);
  // twoLevelTree.root.left = new BSTNode(5);
  // twoLevelTree.root.right = new BSTNode(15);
  // twoLevelTree.print()
  // console.log("min of two nodes tree: ", twoLevelTree.min());
  // console.log("max of two nodes tree: ", twoLevelTree.max());
  /* threeLevelTree 
          root
          10
        /   \
      5     15
    / \    / \
  2   6  13  
  */
  // const threeLevelTree = new BinarySearchTree();
  // threeLevelTree.root = new BSTNode(10);
  // threeLevelTree.root.left = new BSTNode(5);
  // threeLevelTree.root.left.left = new BSTNode(2);
  // threeLevelTree.root.left.right = new BSTNode(6);
  // threeLevelTree.root.right = new BSTNode(15);
  // threeLevelTree.root.right.left = new BSTNode(13);
  // threeLevelTree.print()
  // console.log("min of three nodes tree: ", threeLevelTree.min());
  // console.log("max of three nodes tree: ", threeLevelTree.max());
  
  // console.log("===== Testing 'contains' method =====");
  // console.log(threeLevelTree.contains(15)); // true
  // console.log(threeLevelTree.contains(100)); // false
  
  // console.log("\n===== Testing 'containsRecursive' method =====");
  // console.log(threeLevelTree.containsRecursive(6)); // true
  // console.log(threeLevelTree.containsRecursive(3)); // false
  
  // console.log("\n===== Testing 'range' method =====");
  // console.log(threeLevelTree.range()); // 13 (15 - 2)
  // console.log(threeLevelTree.range(threeLevelTree.root.left)); // 4 (6 - 2)
  // console.log(threeLevelTree.range(threeLevelTree.root.right)); // 2 (15 - 13)
  // Create a new binary search tree
  const testTree = new BinarySearchTree();
  
  // Test the insert method
  console.log("Testing insert method...");
  testTree.insert(10);
  testTree.insert(5);
  testTree.insert(15);
  testTree.insert(3);
  testTree.insert(7);
  testTree.insert(12);
  testTree.insert(17);
  console.log("Tree after using insert:");
  testTree.print();
  /*     
          10
        /   \
      5     15
    / \    / \
  3   7  12  17
  */ 
  // Create another tree for testing insertRecursive
  const recursiveTree = new BinarySearchTree();
  
  // Test the insertRecursive method
  console.log("\nTesting insertRecursive method...");
  recursiveTree.insertRecursive(20);
  recursiveTree.insertRecursive(10);
  recursiveTree.insertRecursive(30);
  recursiveTree.insertRecursive(5);
  recursiveTree.insertRecursive(15);
  recursiveTree.insertRecursive(25);
  recursiveTree.insertRecursive(35);
  console.log("Tree after using insertRecursive:");
  recursiveTree.print();
  /*     
        20
      /   \
    10     30
    / \    / \
  5   15  25  35
  */ 
  