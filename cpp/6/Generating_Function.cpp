/*Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.*/
#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

int main(){

	double n=100;

	n = ( pow(n,4)/4 + pow(n,3)/6 - pow(n,2)/4 - n/6 );
	
	cout << int(n+0.5) << endl;

	return 0;
}
