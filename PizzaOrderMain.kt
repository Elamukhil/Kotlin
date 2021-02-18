fun main(args: Array<String>) {
        println("------------------------------------")
        println("Pizza Order Program!")
        println("------------------------------------")

        val pizzas = mutableListOf<Pizza>()
        println("Enter the total pizzas you would like to order: ")
        val totalPizzas = Integer.valueOf(readLine())
        for (i in 1..totalPizzas) {
            val pizza = Pizza()
            val toppings = mutableListOf<String>()

            println("Enter the size of the pizza \nLarge: Rs.150 \nMedium: Rs.120 \nSmall: Rs.100")
            val pizzasize:String = readLine()!!
            pizza.size=pizzasize
            println("Enter the base of the pizza\n" +
                    "Hand tossed: + 0\n" +
                    "Wheat thin crust: + Rs. 20\n" +
                    "Cheese burst: + Rs. 40 ")

            val pizzaBase:String = readLine()!!
            pizza.base = pizzaBase
            println("Enter the total amount of toppings on the pizza: ")
            val totalToppings = Integer.valueOf(readLine())
            for (j in 1..totalToppings) {
                println("Enter the topping: Add Toppings (Non-veg):\n" +
                        "Bbq chicken : + Rs. 50\n" +
                        "Spicy chicken: + Rs.60\n" +
                        "Tikka chicken: + Rs.40\n" +
                        "\n" +
                        "Add Toppings (Veg):\n" +
                        "Olives: + Rs. 30\n" +
                        "Onions: + Rs. 20\n" +
                        "Baby corn: + Rs. 40")
                val topping:String = readLine()!!
                toppings.add(topping)
            }
            pizza.toppings = toppings
            println("Do you need extra cheese\nYes\nNo")
            val cheese:String= readLine()!!
            pizza.cheese=cheese
            pizzas.add(pizza)
        }

        val order = PizzaOrder(pizzas)
        order.calculateTotalOrderCost()
        order.printOrderSummary()

    }
