//Выведите на экран любое значение с помощью console.log
var text = "Любое значение";
console.log(text);

//Создайте две переменные с числами. Выведите их на экран
var numberOne = 1;
var numberTwo = 2;
console.log("Первое число: " + numberOne);
console.log("Второе число: " + numberTwo);

//Сложите две переменные и выведите результат на экран
var sum = numberOne + numberTwo;
console.log("Сумма: " + sum);

//Поищите в интернете функции для преобразования строки в верхний и нижний регистр.
//Выведите на экран два этих значения
console.log("Верхний регистр: " + text.toUpperCase());
console.log("Нижний регистр: " + text.toLowerCase());

//Запишите в свой скрипт реализацию каждой базовой операции над числами.
//Также посмотрите в интернете как возводить число в квадрат, получать остаток от деления
function add(a, b) {
  return a + b;
}

function sub(a, b) {
  return a - b;
}

function multiply(a, b) {
  return a * b;
}

function division(a, b) {
  if (b != 0) {
    return a / b;
  } else {
    return null;
  }
}

function square(a) {
  return a * a;
}

function mod(a, b) {
  if (b != 0) {
    return a % b;
  } else {
    return null;
  }
}

console.log("Сложение:", add(5, 3)); // 8
console.log("Вычитание:", sub(10, 4)); // 6
console.log("Умножение:", multiply(7, 2)); // 14
console.log("Деление:", division(15, 3)); // 5
console.log("Возведение в квадрат:", square(6)); // 36
console.log("Остаток от деления:", mod(10, 3)); // 1

//Придумайте два задания и покажите преподавателю

//1. Создайте массив с числами и найдите их среднее значение
const numbers = [85, 90, 78, 92, 88];
var sum = 0;
numbers.forEach((number) => {
  sum += number;
});

console.log("Среднее значение: " + division(sum, numbers.length));

//2. Реализуйте болотную сортировку в виде функции

function isSort(array) {
  for (let i = 0; i < array.length - 1; i++) {
    if (array[i] > array[i + 1]) {
      return false;
    }
  }
  return true;
}

function bestSort(array) {
    while (isSort(array) === false) {
        array.sort(() => Math.random() - 0.5);
    }
    return array;
}

const array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];
console.log(array);
console.log(bestSort(array));
