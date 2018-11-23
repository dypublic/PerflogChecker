package checker

interface FieldValidator {
    fun check(value: String): String
}

class NumberValidator (private var min :Int, private var max: Int): FieldValidator {
    override fun check(value :String): String {
        return try {
            var v = value.toInt()
            if (v > this.max ){
                "$value great than max $max"
            } else if ( v < this.min) {
                "$value less than min $min"
            } else {
                ""
            }
        } catch (e :NumberFormatException){
            "not a number"
        }
    }
}
