class PizzaOrder(private val pizzas: MutableList<Pizza>) {
    private var totalOrderCost = 0.0
    var count=0
    fun calculateTotalOrderCost() {
        for (pizza in pizzas) {
            totalOrderCost=0.0
            totalOrderCost += when (pizza.size) {
                "Large" -> 150.0
                "Medium" -> 120.0
                "Small" -> 100.0
                else -> 0.0
            }
                totalOrderCost += when (pizza.base) {
                    "Hand tossed"-> 0.0
                    "Wheat thin crust" -> 20.0
                    "Cheese burst" ->40.0
                    else -> 0.0
                }
                for (topping in pizza.toppings) {
                    totalOrderCost += when (topping) {
                        "Bbq chicken" -> 50.0
                        "Spicy chicken" ->60.0
                        "Tikka chicken" -> 40.0
                        "Olives"->30.0
                        "Onions"-> 20.0
                        "Baby corn"->40.0

                        else -> 0.0
                    }
                }
            if(pizza.cheese=="Yes")
            totalOrderCost += 20.0
            if(pizza.size=="Medium")
                count=count+1
            pizza.cost=totalOrderCost
        }
    }

    fun printOrderSummary() {
        for (pizza in pizzas) {
            if (pizza.cheese == "Yes")
                println("Ordered a " + pizza.size + " pizza with " + pizza.toppings + " with extra cheese [Rs." + pizza.cost+"]")
            else {
                println("Ordered a " + pizza.size + " pizza with " + pizza.toppings +"[Rs." + pizza.cost + "]")
            }
        }
        var totalbill=0.0
        for(pizza in pizzas)
        {
            totalbill+=pizza.cost
        }
        if(count%2==0 && count!=0) {
            println("Todays offer applied : Medium pizza each of Rs.100")
            println("Discount : "+count*20.0)
            totalbill = totalbill - (count * 20.0)
        }
        else
        {
            println("Do you want to apply coupon")
            val coupon : String=readLine()!!
            if(coupon=="Yes") {
                println(
                    "10% off upto Rs.30 on Rs 200 and above, if the code “ZOHO” used.\n" +
                            "20% off upto Rs. 100 on Rs. 400 and above, if the code “JUMBO” used"
                )

                println("Enter the couponcode")
                val couponcode: String = readLine()!!
                if (couponcode == "ZOHO" && totalbill >= 200) {
                    val zohocoupon: Double = (10.0 / 100) * totalbill
                    if (zohocoupon >= 30.0) {
                        totalbill -= 30
                        println("Zoho coupon applied : Discount : 30.0")
                    } else {
                        totalbill -= zohocoupon
                        println("Zoho coupon applied : Discount : $zohocoupon")
                    }
                }
                else if (couponcode == "JUMBO" && totalbill >= 400) {
                    val jumbocoupon: Double = (20.0 / 100) * totalbill
                    if (jumbocoupon >= 100.0) {
                        totalbill -= 100
                        println("Jumbo coupon applied : Discount : 100.0")
                    } else {
                        totalbill -= jumbocoupon
                        println("Jumbo coupon applied : Discount : $jumbocoupon")
                    }
                }
                else
                    println("Coupon not valid")
            }

        }
        val tax:Double=(12.0/100)*totalbill
        totalbill+=tax
        println("Tax 12% = $tax" )
        println("TOTAL ORDER AMOUNT: $totalbill")
    }
}