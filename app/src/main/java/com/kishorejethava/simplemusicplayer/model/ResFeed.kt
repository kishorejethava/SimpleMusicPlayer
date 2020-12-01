package com.kishorejethava.simplemusicplayer.model


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
data class ResFeed(
    @SerializedName("feed") val feed: Feed
) : BaseResult() {
    @Keep
    data class Feed(
        @SerializedName("author") val author: Author,
        @SerializedName("entry") val entries: ArrayList<Entry>,
        @SerializedName("icon") val icon: Icon,
        @SerializedName("id") val id: Id,
        @SerializedName("link") val link: List<Link>,
        @SerializedName("rights") val rights: Rights,
        @SerializedName("title") val title: Title?,
        @SerializedName("updated") val updated: Updated
    ) {
        @Keep
        data class Author(
            @SerializedName("name") val name: Name,
            @SerializedName("uri") val uri: Uri
        ) {
            @Keep
            data class Name(
                @SerializedName("label") val label: String
            )

            @Keep
            data class Uri(
                @SerializedName("label") val label: String
            )
        }

        @Parcelize
        @Keep
        data class Entry(
            @SerializedName("category") val category: Category,
            @SerializedName("id") val id: Id,
            @SerializedName("im:artist") val imArtist: ImArtist,
            @SerializedName("im:collection") val imCollection: ImCollection,
            @SerializedName("im:contentType") val imContentType: ImContentType,
            @SerializedName("im:image") val imImage: List<ImImage>,
            @SerializedName("im:name") val imName: ImName,
            @SerializedName("im:price") val imPrice: ImPrice,
            @SerializedName("im:releaseDate") val imReleaseDate: ImReleaseDate,
            @SerializedName("link") val link: List<Link>,
            @SerializedName("rights") val rights: Rights,
            @SerializedName("title") val title: Title?
        ) : Parcelable {
            @Parcelize
            @Keep
            data class Category(
                @SerializedName("attributes") val attributes: Attributes
            ) : Parcelable {
                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("im:id") val imId: String,
                    @SerializedName("label") val label: String,
                    @SerializedName("scheme") val scheme: String,
                    @SerializedName("term") val term: String
                ) : Parcelable
            }
            @Parcelize
            @Keep
            data class Id(
                @SerializedName("attributes") val attributes: Attributes,
                @SerializedName("label") val label: String
            ) : Parcelable {
                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("im:id") val imId: String
                ) : Parcelable
            }
            @Parcelize
            @Keep
            data class ImArtist(
                @SerializedName("attributes") val attributes: Attributes,
                @SerializedName("label") val label: String
            ) : Parcelable {
                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("href") val href: String
                ) : Parcelable
            }
            @Parcelize
            @Keep
            data class ImCollection(
                @SerializedName("im:contentType") val imContentType: ImContentType,
                @SerializedName("im:name") val imName: ImName,
                @SerializedName("link") val link: Link
            ) : Parcelable {
                @Parcelize
                @Keep
                data class ImContentType(
                    @SerializedName("attributes") val attributes: Attributes,
                    @SerializedName("im:contentType") val imContentType: ImContentType
                ) : Parcelable {
                    @Parcelize
                    @Keep
                    data class Attributes(
                        @SerializedName("label") val label: String,
                        @SerializedName("term") val term: String
                    ) : Parcelable

                    @Parcelize
                    @Keep
                    data class ImContentType(
                        @SerializedName("attributes") val attributes: Attributes
                    ) : Parcelable {
                        @Parcelize
                        @Keep
                        data class Attributes(
                            @SerializedName("label") val label: String,
                            @SerializedName("term") val term: String
                        ) : Parcelable
                    }
                }

                @Parcelize
                @Keep
                data class ImName(
                    @SerializedName("label") val label: String
                ) : Parcelable

                @Parcelize
                @Keep
                data class Link(
                    @SerializedName("attributes") val attributes: Attributes
                ) : Parcelable {
                    @Parcelize
                    @Keep
                    data class Attributes(
                        @SerializedName("href") val href: String,
                        @SerializedName("rel") val rel: String,
                        @SerializedName("type") val type: String
                    ) : Parcelable
                }
            }

            @Parcelize
            @Keep
            data class ImContentType(
                @SerializedName("attributes") val attributes: Attributes,
                @SerializedName("im:contentType") val imContentType: ImContentType
            ) : Parcelable {
                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("label") val label: String,
                    @SerializedName("term") val term: String
                ) : Parcelable

                @Parcelize
                @Keep
                data class ImContentType(
                    @SerializedName("attributes") val attributes: Attributes
                ) : Parcelable {
                    @Parcelize
                    @Keep
                    data class Attributes(
                        @SerializedName("label") val label: String,
                        @SerializedName("term") val term: String
                    ) : Parcelable
                }
            }

            @Parcelize
            @Keep
            data class ImImage(
                @SerializedName("attributes") val attributes: Attributes,
                @SerializedName("label") val label: String
            ) : Parcelable {
                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("height") val height: String
                ) : Parcelable
            }

            @Parcelize
            @Keep
            data class ImName(
                @SerializedName("label") val label: String
            ) : Parcelable

            @Parcelize
            @Keep
            data class ImPrice(
                @SerializedName("attributes") val attributes: Attributes,
                @SerializedName("label") val label: String
            ) : Parcelable {
                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("amount") val amount: String,
                    @SerializedName("currency") val currency: String
                ) : Parcelable
            }

            @Parcelize
            @Keep
            data class ImReleaseDate(
                @SerializedName("attributes") val attributes: Attributes,
                @SerializedName("label") val label: String
            ) : Parcelable {
                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("label") val label: String
                ):Parcelable
            }

            @Parcelize
            @Keep
            data class Link(
                @SerializedName("attributes") val attributes: Attributes,
                @SerializedName("im:duration") val imDuration: ImDuration?
            ) : Parcelable {

                @Parcelize
                @Keep
                data class Attributes(
                    @SerializedName("href") val href: String,
                    @SerializedName("im:assetType") val imAssetType: String?,
                    @SerializedName("rel") val rel: String,
                    @SerializedName("title") val title: String?,
                    @SerializedName("type") val type: String
                ) : Parcelable

                @Parcelize
                @Keep
                data class ImDuration(
                    @SerializedName("label") val label: String
                ): Parcelable
            }

            @Parcelize
            @Keep
            data class Rights(
                @SerializedName("label") val label: String
            ) : Parcelable

            @Parcelize
            @Keep
            data class Title(
                @SerializedName("label") val label: String?
            ) : Parcelable
        }

        @Keep
        data class Icon(
            @SerializedName("label") val label: String
        )

        @Keep
        data class Id(
            @SerializedName("label") val label: String
        )

        @Keep
        data class Link(
            @SerializedName("attributes") val attributes: Attributes
        ) {
            @Keep
            data class Attributes(
                @SerializedName("href") val href: String,
                @SerializedName("rel") val rel: String,
                @SerializedName("type") val type: String
            )
        }

        @Keep
        data class Rights(
            @SerializedName("label") val label: String
        )

        @Keep
        data class Title(
            @SerializedName("label") val label: String?
        )

        @Keep
        data class Updated(
            @SerializedName("label") val label: String
        )
    }
}