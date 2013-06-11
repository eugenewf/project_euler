/*largest prime factor of 600851475143*/
#include <stdio.h>

int main(){
	long int remaining = 600851475143, n=3;

	while (remaining != 1){
		if(remaining%n==0){
			remaining /= n;
		}else{
			n += 2;
		}
	}
	fprintf(stdout, "%ld\n", n);
	return 0;
}
