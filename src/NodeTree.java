
public class NodeTree {
	public Products pro;		
	public NodeTree tLeft;
	public NodeTree tRight;
	
	public Products getPro() {
		return pro;
	}

	public void setPro(Products pro) {
		this.pro = pro;
	}

	public NodeTree getTLeft() {
		return tLeft;
	}

	public void setTLeft(NodeTree tLeft) {
		this.tLeft = tLeft;
	}

	public NodeTree getTRight() {
		return tRight;
	}

	public void setTRight(NodeTree tRight) {
		this.tRight = tRight;
	}

	
	public NodeTree(Products pro) {
		this.pro = pro;
		tRight = tLeft = null;
	}
	

}
