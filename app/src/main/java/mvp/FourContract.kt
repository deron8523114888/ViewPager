package mvp

interface FourContract {

    interface View {
        fun showData(data: String) {}
    }

    interface Presenter {

        fun getApiData(position: Int)

    }


}