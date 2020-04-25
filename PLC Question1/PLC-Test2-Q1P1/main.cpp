#include <iostream>

enum numbers{
	one = 1,
	two = 2,
	three = 3,
	four = 4,
	five = 5,
	six = 6,
	seven = 7,
	eight = 8,
	nine = 9,
	ten = 10,
};
	
enum random{
	hundred = 100,
  twohundred = 200,
};

int main() {
  std::cout << (one+ten) << std::endl;
  std::cout << (two+nine) << std::endl;
  std::cout << (three+eight) << std::endl;
  std::cout << (four+seven) << std::endl;
  std::cout << (five+six) << std::endl;
  std::cout << (ten-one) << std::endl;
  std::cout << (nine-two) << std::endl;
  std::cout << (eight-three) << std::endl;
  std::cout << (seven-four) << std::endl;
  std::cout << (six-five) << std::endl;
  std::cout << (hundred*twohundred) << std::endl;
  std::cout << (hundred+one) << std::endl;
  std::cout << (hundred/two) << std::endl;
  std::cout << (hundred*three) << std::endl;
  std::cout << (hundred/four) << std::endl;
  std::cout << (hundred/five) << std::endl;
  std::cout << (hundred*six) << std::endl;
  std::cout << (hundred*seven) << std::endl;
  std::cout << (hundred*eight) << std::endl;
  std::cout << (hundred*nine) << std::endl;
  std::cout << (hundred/ten) << std::endl;
};