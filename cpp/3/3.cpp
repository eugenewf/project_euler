/*What is the largest prime factor of the number 600851475143?*/
/*not worth number field sieve*/

#include <iostream>
#include <cmath>
using namespace std;

int main(){

	long 	i=1,
		remaining=600851475143;

	while(i <= (long)sqrt((long double)remaining)){
		i++;
		while(remaining%i==0){
			remaining/=i;
			//cout << "factor: " << i << "\tremaining: " << remaining <<endl;
		}
	}

	if(remaining==1){
		cout << i << endl;
	}else{
		cout << remaining << endl;
	}


	return 0;
}
