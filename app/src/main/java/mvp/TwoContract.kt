package mvp

interface TwoContract {

    interface View {
        fun showData(data: String) {}
    }

    interface Presenter {

        fun getApiData(position: Int)

    }


}