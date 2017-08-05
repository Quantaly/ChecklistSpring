package kpage.chklists.pojos;

import java.util.List;

import javax.persistence.Entity;

import kpage.chklists.pojos.utils.XMLUtils;

@Entity
public class Heading extends Checklist {

	private String name;
	
	public Heading() {
		this("", null);
	}

	public Heading(String name, List<ChecklistItem> items) {
		super(items);
		this.name = name;
	}

	public Heading(String name, List<ChecklistItem> items, List<Heading> subheadings) {
		super(items, subheadings);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String ret = "~~ " + name + " ~~";
		for (ChecklistItem ci : items) {
			ret += "\n" + ci.toString();
		}
		for (Heading h : subheadings) {
			ret += "\n" + h.toStringAsSub();
		}
		return ret;
	}

	protected String toStringAsSub() {
		String ret = "~ " + name;
		for (ChecklistItem ci : items) {
			ret += "\n" + ci.toString();
		}
		for (Heading h : subheadings) {
			ret += "\n" + h.toStringAsSub();
		}
		return ret;
	}

	@Override
	public String toXML() {
		String orig = super.toXML();
		String[] split = orig.split("\n");
		split[0] = "<head name=\"" + XMLUtils.escapeChars(getName()) + "\">";
		split[split.length - 1] = "</head>";
		return String.join("\n", split);
	}

}
