package pt.dfsg.seriestracker.data.model

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import pt.dfsg.seriestracker.data.local.ListStringConverter

data class Search(
    var score: Double?,
    var show: Show?
)

@Entity
@TypeConverters(ListStringConverter::class)
data class Show(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var url: String?,
    var name: String?,
    var type: String?,
    var summary: String?,
    var language: String?,
    var genres: List<String?>?,
    var status: String?,
    var runtime: Int?,
    var premiered: String?,
    var officialSite: String?,
    var weight: Int?,
    var updated: Int?,
    @Embedded var image: Image?,
    @Embedded var schedule: Schedule?,
    @Embedded var rating: Rating?,
    @Embedded var externals: Externals?,
    @Embedded var network: Network?,
    @Embedded var webChannel: WebChannel?
)

data class Image(
    var medium: String?,
    var original: String?
)

data class Schedule(
    var time: String?,
    var days: List<String?>?
)

data class Rating(
    var average: Double?
)

data class Externals(
    var tvrage: Int?,
    var thetvdb: Int?,
    var imdb: String?
)

data class Nextsepisode(
    @ColumnInfo(name = "next_episode_href") var href: String?
)

data class Network(
    @ColumnInfo(name = "id_network") var id: Int?,
    @ColumnInfo(name = "network_name") var name: String?,
    @SerializedName("country") @Embedded var countryNetwork: CountryNetwork?
)

data class WebChannel(
    @ColumnInfo(name = "id_webchannel") var id: Int?,
    @ColumnInfo(name = "webchannel_name") var name: String?,
    @SerializedName("country") @Embedded var countryWeb: CountryWebChannel?
)

data class CountryNetwork(
    @ColumnInfo(name = "net_country_name") var name: String?,
    @ColumnInfo(name = "net_country_code") var code: String?,
    @ColumnInfo(name = "net_country_timezone") var timezone: String?
)

data class CountryWebChannel(
    @ColumnInfo(name = "web_country_name") var name: String?,
    @ColumnInfo(name = "web_country_code") var code: String?,
    @ColumnInfo(name = "web_country_timezone") var timezone: String?
)

