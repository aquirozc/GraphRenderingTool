package mx.uaemex.fi.linc13.saturn.presentation;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBLayoutBuilder{

    private final GridBagConstraints cons;

	public GBLayoutBuilder () {
		cons = new GridBagConstraints();
	}

	public GBLayoutBuilder start() {
		resetConstraints();
		return this;
	}

	public GBLayoutBuilder startAt(int gridx, int gridy) {
		resetConstraints();
		return coords(gridx, gridy);
	}

	public GBLayoutBuilder anchor(int anchor) {
		cons.anchor = anchor;
		return this;
	}

	public GBLayoutBuilder coords(int gridx, int gridy) {
		cons.gridx = gridx;
		cons.gridy = gridy;
		return this;
	}

	public GBLayoutBuilder insets(Insets i){
		cons.insets = i;
		return this;
	}

	public GBLayoutBuilder fill(int fill) {
		cons.fill = fill;
		return this;
	}

	public GBLayoutBuilder gridheight(int gridheight) {
		cons.gridheight = gridheight;
		return this;
	}

	public GBLayoutBuilder gridwidth(int gridwidth) {
		cons.gridwidth = gridwidth;
		return this;
	}

	public GBLayoutBuilder gridx(int gridx) {
		cons.gridx = gridx;
		return this;
	}

	public GBLayoutBuilder gridy(int gridy) {
		cons.gridy = gridy;
		return this;
	}

	public GBLayoutBuilder ipadx(int ipadx) {
		cons.ipadx = ipadx;
		return this;
	}

	public GBLayoutBuilder ipady(int ipady) {
		cons.ipady = ipady;
		return this;
	}


	public GBLayoutBuilder marginB(int m) {
		cons.insets.bottom = m;
		return this;
	}

	public GBLayoutBuilder marginL(int m) {
		cons.insets.left = m;
		return this;
	}

	public GBLayoutBuilder marginR(int m) {
		cons.insets.right = m;
		return this;
	}

	public GBLayoutBuilder marginT(int m) {
		cons.insets.top = m;
		return this;
	}

	public GBLayoutBuilder weightx(double weightx) {
		cons.weightx = weightx;
		return this;
	}

	public GBLayoutBuilder weighty(double weighty) {
		cons.weighty = weighty;
		return this;
	}

	public GridBagConstraints build() {
		return cons;
	}

	private void resetConstraints() {
		 cons.anchor = GridBagConstraints.LINE_START;
	     cons.insets = new Insets(0,0,0,0);
	     cons.fill = GridBagConstraints.NONE;
	     cons.gridwidth = 1;
	     cons.gridheight = 1;
	     cons.gridx = 0;
	     cons.gridy = 0;
	     cons.ipadx = 0;
	     cons.ipady = 0;
	     cons.weighty = 0;
	     cons.weightx = 0;
	}

}
