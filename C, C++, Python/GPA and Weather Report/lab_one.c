#include <stdio.h>
void main(void)
{
		int age = 21;
		float gpa = 3.5;
			printf("Gio is %d years old and has a %.2f GPA.\n", age, gpa);
		
		float PI = 3.14159;
		int r = 5;
		float c = 2 * PI * r;
			printf("The circumference of a circle with radius %d is %4.2f.\n", r, c);  



        typedef enum {RAIN, WIND, SNOW, SUNSHINE} Weather;
        Weather m = WIND;

        switch(m) {
                case RAIN:
                        printf("Rain; bring an umbrella\n");
                        break;
                case WIND:
                        printf("Wind; bring a kite\n");
                        break;
                case SNOW:
                        printf("Snow; bring gloves and a carrot\n");
                        break;
				case SUNSHINE:
                        printf("Sunshine; bring swimming clothes\n");
                        break;
                default:
                        printf("Unknown weather; the world is ending\n");
        }

}