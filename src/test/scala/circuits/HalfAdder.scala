package circuits

import Chisel.fromtIntToLiteral
import chisel3.{Hexadecimal, PrintableHelper}
import chisel3.iotesters.{Driver, PeekPokeTester}


class HalfAdderTests(c: HalfAdder) extends PeekPokeTester(c) {

  var i0 = 1
  var i1 = 1
  poke(c.io.b, i0)
  poke(c.io.a, i1)
  step(1)
  printf("i0: %d i1: %d carry: %d sum: %d\n", i0,i1, peek(c.io.carry), peek(c.io.sum))
  i0=0
  i1=1
  poke(c.io.b, i0)
  poke(c.io.a, i1)
  step(1)
  printf("i0: %d i1: %d carry: %d sum: %d\n", i0,i1, peek(c.io.carry), peek(c.io.sum))
  i0=0
  i1=0
  poke(c.io.b, i0)
  poke(c.io.a, i1)
  step(1)
  printf("i0: %d i1: %d carry: %d sum: %d\n", i0,i1, peek(c.io.carry), peek(c.io.sum))
  i0=1
  i1=0
  poke(c.io.b, i0)
  poke(c.io.a, i1)
  step(1)
  printf("i0: %d i1: %d carry: %d sum: %d\n", i0,i1, peek(c.io.carry), peek(c.io.sum))
}

object Hello6 {
  def main(args: Array[String]): Unit = {
    if (!Driver(() => new HalfAdder())(c => new HalfAdderTests(c))) System.exit(1)
  }
}
