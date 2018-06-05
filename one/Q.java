class Rectangle
	{
	private final float length;
	private final float breadth;
	Rectangle(float Length,float Breadth)
		{
		this.length = Length;
		this.breadth = Breadth;
		}
	public final float getArea()
		{
		return (this.length) * (this.breadth);
		}
	public final float  getPerimeter()
		{
		return 2*(this.length + this.breadth);
		}
	}

class Square extends Rectangle
	{
	Square(float length)
		{
		super(length,length);
		}
	}

class Triangle extends Rectangle{

Triangle(float length)
		{
		super(length,length);
		}
}


public class Q
	{
	
	public static void main(String args[])
		{
		Rectangle R1 = new Rectangle(2.0f,3.0f);
		Rectangle S1 = new Square(2.0f);
		Rectangle P1 = new Point();
		Rectangle[]s = {R1,S1,P1};
		printDetails(s);
		}
	public static void printDetails(Rectangle[] rs)
			{
			for(Rectangle s : rs)
				{
				System.out.println("area "+s.getArea());
				System.out.println("Perimeter "+s.getPerimeter());
				}
			}
	}
