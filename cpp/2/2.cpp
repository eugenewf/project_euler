/*By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.*/

#include <iostream>
using namespace std;

int main(){
	int 	n=1,
		n_minus_one=0,
		n_minus_two=0,
		sum=0;

	while(n<4000000){
		sum+=n*(n%2);
		n_minus_two=n_minus_one;
		n_minus_one=n;
		n=n_minus_one+n_minus_two;
	}

	cout << sum << endl;
	return 0;
}

