#include <iostream>
#include <chrono>
#include <ctime> 

void staticArray(){
    int static x[1000];
}

void heapArray(){
    int *z;
    z = new int[1000];
}

void stackArray(){
    int x[1000];
}

int main() {
  auto start = std::chrono::system_clock::now();
	for(int i = 0; i < 100000; i++) {
		staticArray();
	}
  auto end = std::chrono::system_clock::now();
  std::chrono::duration<double> elapsed = end-start;
  std::cout << "Static array took " << elapsed.count() << " secs\n";

  start = std::chrono::system_clock::now();
	for(int i = 0; i < 100000; i++) {
		heapArray();
	}
  end = std::chrono::system_clock::now();
  elapsed = end-start;
  std::cout << "Heap array took " << elapsed.count() << " secs\n";

  start = std::chrono::system_clock::now();
	for(int i = 0; i < 100000; i++) {
		stackArray();
	}
  end = std::chrono::system_clock::now();
  elapsed = end-start;
  std::cout << "Stack array took " << elapsed.count() << " secs\n";
}