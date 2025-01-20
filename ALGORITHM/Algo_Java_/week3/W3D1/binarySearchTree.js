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
      const node = new BSTNode(newVal);
      if (this.isEmpty()) {
        this.root = node;
        return this;
      }
      let current = this.root;
      while (true) {
        if (newVal <= current.data) {
          if (current.left === null) {
            current.left = node;
            return this;
          } else {
            current = current.left;
          }
        } else {
          if (current.right === null) {
            current.right = node;
            return this;
          }
          current = current.right;
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
      //your code here
    }
    //TODO
    /**
     * DFS Preorder: (CurrNode, Left, Right)
     * Converts this BST into an array following Depth First Search preorder.
     * Example on the fullTree var:
     * [25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90]
     * @param {Node} node The current node during the traversal of this tree.
     * @param {Array<number>} vals The data that has been visited so far.
     * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
     */
    toArrPreorder(node = this.root, vals = []) {
      //TODO: your code here
      // condition to keep pushing the data
      if(node!=null){
        // pushing the current node data
        vals.push(node.data)
        // keep moving to the left until we reach null
        this.toArrPreorder(node.left,vals)
        // keep moving to the right until we reach null
        this.toArrPreorder(node.rigt,vals)
      }
      // we return our arr of vals
      return vals;
    }
  
    /**
     * DFS Inorder: (Left, CurrNode, Right)
     * Converts this BST into an array following Depth First Search inorder.
     * See debugger call stack to help understand the recursion.
     * Example on the fullTree var:
     * [4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90]
     * @param {Node} node The current node during the traversal of this tree.
     * @param {Array<number>} vals The data that has been visited so far.
     * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
     */
    toArrInorder(node = this.root, vals = []) {
      //TODO: your code here
      if(node!=null){
        this.toArrInorder(node.left,vals)
        vals.push(node.data)
        this.toArrInorder(node.right,vals)
      }
      return vals;
    }
  
    /**
     * DFS Postorder (Left, Right, CurrNode)
     * Converts this BST into an array following Depth First Search postorder.
     * Example on the fullTree var:
     * [4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25]
     * @param {Node} node The current node during the traversal of this tree.
     * @param {Array<number>} vals The data that has been visited so far.
     * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
     */
    toArrPostorder(node = this.root, vals = []) {
      //TODO: your code here
      if(node!=null){
        this.toArrPostorder(node.left,vals)
        this.toArrPostorder(node.right,vals)
        vals.push(node.data)
      }
      return vals;
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
  
  const bst = new BinarySearchTree();
  
  bst.insert(25);
  bst.insert(15);
  bst.insert(50);
  bst.insert(10);
  bst.insert(22);
  bst.insert(35);
  bst.insert(70);
  bst.insert(4);
  bst.insert(12);
  bst.insert(18);
  bst.insert(24);
  bst.insert(31);
  bst.insert(44);
  bst.insert(66);
  bst.insert(90);
  bst.print()
  // Test DFS Preorder
  const preorderResult = bst.toArrPreorder();
  console.log("DFS Preorder Traversal (CurrNode, Left, Right):", preorderResult);
  // Expected output: [25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90]
  
  // Test DFS Inorder
  const inorderResult = bst.toArrInorder();
  console.log("DFS Inorder Traversal (Left, CurrNode, Right):", inorderResult);
  // Expected output: [4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90]
  
  // Test DFS Postorder
  const postorderResult = bst.toArrPostorder();
  console.log("DFS Postorder Traversal (Left, Right, CurrNode):", postorderResult);
  // Expected output: [4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25]
  