public class Figure implements Cloneable {
    String color;
    Integer sqare;

    public  Figure(String _color, Integer _sqare){
        this.color = _color;
        this.sqare = _sqare;
    }

    public Figure(){}

    public Integer getSqare() {
        return sqare;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSqare(Integer sqare) {
        this.sqare = sqare;
    }

    @Override
    public String toString() {
        return "Figure color: " + this.color + ", sqare = " + this.sqare + ". Hash = " + this.hashCode();
    }

    public Figure clone() {
        try {
            return (Figure)super.clone();
        }
        catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if (obj instanceof Figure){
            Figure o  = (Figure) obj;
            return o.sqare.equals(this.sqare) && o.color.equals(this.color);
        }
        else
            return false;

    }


}
