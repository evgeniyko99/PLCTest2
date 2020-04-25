#include <iostream>

enum daysOfTheWeek {
  monday = 1, 
  tuesday = 2,
  wednesday = 3,
  thursday = 4,
  friday = 5,
  saturday = 6,
  sunday = 7
};

enum classes {
  noClasses = 0,
  classes = 1
};

int main() {

  int today = 1;

  if(today > 2 && today < 5) {
    std::cout << "You have classes today" << std::endl;
  } else {
    std::cout << "You do not have classes today" << std::endl;
  }
}