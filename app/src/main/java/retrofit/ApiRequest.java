package retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiRequest {
//    @POST("user/register")
//    Call<DetailsResponse> getRegistered(
//            @Query("name") String name,
//            @Query("email") String email,
//            @Query("address") String address,
//            @Query("dob") String dob,
//            @Query("gender") String gender
//    );
//@Headers({"Accept: application/json"})
//@POST("user/register")
//    Call<DetailsResponse> getRegistered(
//            @Body User user,
//            @Query("mobile") String mobile
//    );


//    @Headers({"Accept: application/json"})
//@POST("user/login")
//    Call<OtpResponse> getLogin(
//            @Query("mobile") String mobile
//);
//
//
//    @Headers({"Accept: application/json"})
//@POST("verify-otp/{id}")
//    Call<MyOtpResponse> getOtp(
//            @Body OTP otp,
//            @Path("id") int id
//);
//
//
//
//
//   @Headers({"Accept: application/json"})
//@GET("providers/")
//    Call<ServiceResponse> getService(
//            @Header("Authorization") String auth
//
//);
//    @Headers({"Accept: application/json"})
//    @POST("drivers")
//    Call<DriverNearYouResponse> getDrivers(
//            @Header("Authorization") String auth,
//            @Query("lat") String lattt,
//            @Query( "lng") String longiii
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("home")
//    Call<HomeResponse> getHome(
//            @Header("Authorization") String auth,
//            @Query("lat") double latt,
//            @Query( "lng") double longii
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("japa-maids/")
//    Call<JapaMaidResponse> getJapaMaid(
//            @Header("Authorization") String auth
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("get-profile-picture/")
//    Call<ProfileResponse> getProfile(
//            @Header("Authorization") String auth
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("driver/{id}")
//    Call<DriversDetailResponse> getDriversDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("unlock-number/{id}")
//    Call<UnlockNumberResponse> getUnlockNumber(
//            @Header("Authorization") String auth,
//            @Path("id") int id,
//            @Query("p_cat_id") int pcat
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("pandit/{id}")
//    Call<PurohitDetailsResponse> purohitDetails(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("japa-maid/{id}")
//    Call<JapaMaidDetailsResponse> japaMaidDetails(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("purane-kapdhe-wala/{id}")
//    Call<PuraneKapdeWalaDetailsResponse> kapdeWalaDetails(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//    @Headers({"Accept: application/json"})
//    @GET("doodhwala/{id}")
//    Call<MilkManDetailsResponse> MilkmanDetails(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("tutor/{id}")
//    Call<HomeTutorDetailResponse> getHomeTutorDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("dog-cat-mover/{id}")
//    Call<DogCatMoversDetailsResponse> dogcatDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("massage/{id}")
//    Call<MalishWalaDetailsResponse> malishwalaDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("kabadhi-wala/{id}")
//    Call<KabadiWalaDetailsResponse> getKabadiWalaDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("carwash/{id}")
//    Call<BikeCarWashersDetailsResponse> carWasherDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("part-time-maid/{id}")
//    Call<PartTimeMaidDetailResponse> maidPartTimeDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("physiotherapist/{id}")
//    Call<PhysiotherapistDetailsResponse> physiotherapistDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("salon-for-female/{id}")
//    Call<WomenSalonDetailResponse> womenSalonDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//
//    @Headers({"Accept: application/json"})
//    @GET("24hr-maid/{id}")
//    Call<Maid24DetailsResponse> maid24Details(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("nurse/{id}")
//    Call<NurseDetailsResponse> nurseDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//
//    @Headers({"Accept: application/json"})
//    @GET("mehendi-artist/{id}")
//    Call<MehndiArtistDetailsResponse> mehndiArtistDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("salon-for-male/{id}")
//    Call<MenSalonDetailsResponse> menSalonDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("cleaner/{id}")
//    Call<BathroomCleanersDetailsResponse> cleanerDetail(
//            @Header("Authorization") String auth,
//            @Path("id") int id
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("user-business/")
//    Call<BusinessListResponse> getBusinessList(
//            @Header("Authorization") String auth
//    );
//    @Headers({"Accept: application/json"})
//    @GET("wallet")
//    Call<WalletResponse> getWallet(
//            @Header("Authorization") String auth
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("store-profile-picture")
//    Call<EditProfileResponse> getEditProfile(
//            @Header("Authorization") String auth,
//            @Body ImageBody image
//    );
//    @Headers({"Accept: application/json"})
//    @POST
//    Call<NearYouResponse> getList(
//            @Header("Authorization") String auth,
//            @Url String url,
//            @Query("lat") String lattt,
//            @Query( "lng") String longiii
//
//    );
//    @Headers({"Accept: application/json"})
//    @POST("create-driver")
//    Call<DriverResponse> AddDriver(
//            @Header("Authorization") String auth,
//            @Body DriversUpload drivers
//    );
//
//
//    //////////////////////////////////  UPDATEEEEE APISSSS
//    @POST("driver/update")
//    Call<DriverResponse> UPDATEDriver(
//            @Header("Authorization") String auth,
//            @Body DriversUpload drivers
//    );
//
//    @POST("cleaner/update")
//    Call<BathroomCleanerResponse> UPDATEcleaner(
//            @Header("Authorization") String auth,
//            @Body Cleaners cleaners
//    );
//
//    @POST("24hr-maid/update")
//    Call<Maid24Response> UPDATEMaid24(
//            @Header("Authorization") String auth,
//            @Body Maid24 maid24
//    );
//
//    @POST("salon-for-female/update")
//    Call<WomenSalonResponse> UPDATEWomenSalon(
//            @Header("Authorization") String auth,
//            @Body WomenSalon womenSalon
//    );
//
//    @POST("pandit/update")
//    Call<PurohitResponse> UPDATEPurohit(
//            @Header("Authorization") String auth,
//            @Body PurohitUpload purohit
//    );
//
//    @POST("doodhwala/update")
//    Call<MilkManResponse> UPDATEMilkMan(
//            @Header("Authorization") String auth,
//            @Body MilkMan milkMan
//    );
//
//    @POST("kabadhi-wala/update")
//    Call<KabadiWalaResponse> UpdateKabadiWala(
//            @Header("Authorization") String auth,
//            @Body KabadiWala kabadiWala
//    );
//
//
//    @POST("tutor/update")
//    Call<HomeTutorResponse> UPDATEHomeTutor(
//            @Header("Authorization") String auth,
//            @Body HomeTutor homeTutor
//    );
//
//    @POST("purane-kapdhe-wala/update")
//    Call<PuraneKapdeWalaResponse> UPDATEKapdeWala(
//            @Header("Authorization") String auth,
//            @Body PuraneKapdeWalaUpload puraneKapdeWalaUpload
//    );
//
//    @POST("car-washer/update")
//    Call<BikeCarWashersResponse> UPDATEBikeCarWasher(
//            @Header("Authorization") String auth,
//            @Body BikeCar bikeCar
//    );
//    @POST("dog-and-cat-mover/update")
//    Call<DogCatMoversResponse> UPDATEDogCatMovers(
//            @Header("Authorization") String auth,
//            @Body DogCat dogCat
//    );
//
//    @POST("massage/update")
//    Call<MalishWalaResponse> UPDATEMalishWala(
//            @Header("Authorization") String auth,
//            @Body MalishWala malishWala
//    );
//
//    @POST("mehendi-artist/update")
//    Call<MehndiArtistResponse> UPDATEMehndiArtist(
//            @Header("Authorization") String auth,
//            @Body MehndiArtist mehndiArtist
//    );
//
//    @POST("salon-for-male/update")
//    Call<MenSalonResponse> UPDATEMenSalon(
//            @Header("Authorization") String auth,
//            @Body MenSaloon menSaloon
//    );
//
//    @POST("part-time-maid/update")
//    Call<PartTimeMaidResponse> UPDATEMaidPartTime(
//            @Header("Authorization") String auth,
//            @Body MaidPartTime maidPartTime
//    );
//    @POST("physio/update")
//    Call<PhysiotherapistResponse> UPDATEPhysiotherapist(
//            @Header("Authorization") String auth,
//            @Body physiotherapist physio
//    );
//
//    @POST("nurse/update")
//    Call<NurseResponse> UPDATENurse(
//            @Header("Authorization") String auth,
//            @Body Nurse nurse
//    );

    ////////////////////////////////////////
//
//    @Headers({"Accept: application/json"})
//    @POST("create-japa-maid")
//    Call<MaidJoinJapaResponse> AddJapaMaid(
//            @Header("Authorization") String auth,
//            @Body JapaMaids japaMaids
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-cleaner")
//    Call<BathroomCleanerResponse> Addcleaner(
//            @Header("Authorization") String auth,
//            @Body Cleaners cleaners
//    );
//
//
//    @Headers({"Accept: application/json"})
//    @POST("create-massage")
//    Call<MalishWalaResponse> AddMalishWala(
//            @Header("Authorization") String auth,
//            @Body MalishWala malishWala
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-nurse")
//    Call<NurseResponse> AddNurse(
//            @Header("Authorization") String auth,
//            @Body Nurse nurse
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-salon-for-female")
//    Call<WomenSalonResponse> AddWomenSalon(
//            @Header("Authorization") String auth,
//            @Body WomenSalon womenSalon
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-physio")
//    Call<PhysiotherapistResponse> AddPhysiotherapist(
//            @Header("Authorization") String auth,
//            @Body physiotherapist physio
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-24hr-maid")
//    Call<Maid24Response> AddMaid24(
//            @Header("Authorization") String auth,
//            @Body Maid24 maid24
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-car-washer")
//    Call<BikeCarWashersResponse> AddBikeCarWasher(
//            @Header("Authorization") String auth,
//            @Body BikeCar bikeCar
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-mehendi-artist")
//    Call<MehndiArtistResponse> AddMehndiArtist(
//            @Header("Authorization") String auth,
//            @Body MehndiArtist mehndiArtist
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-salon-for-male")
//    Call<MenSalonResponse> AddMenSalon(
//            @Header("Authorization") String auth,
//            @Body MenSaloon menSaloon
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-part-time-maid")
//    Call<PartTimeMaidResponse> AddMaidPartTime(
//            @Header("Authorization") String auth,
//            @Body MaidPartTime maidPartTime
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-kabadhi-wala")
//    Call<KabadiWalaResponse> ADDKabadiWala(
//            @Header("Authorization") String auth,
//            @Body KabadiWala kabadiWala
//    );
// @Headers({"Accept: application/json"})
//    @POST("create-milk-man")
//    Call<MilkManResponse> AddMilkMan(
//            @Header("Authorization") String auth,
//            @Body MilkMan milkMan
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-pandit")
//    Call<PurohitResponse> AddPurohit(
//            @Header("Authorization") String auth,
//            @Body PurohitUpload purohitUpload
//    );
//    @Headers({"Accept: application/json"})
//    @POST("create-purane-kapdhe-wala")
//    Call<PuraneKapdeWalaResponse> AddKapdeWala(
//            @Header("Authorization") String auth,
//            @Body PuraneKapdeWalaUpload puraneKapdeWalaUpload
//    );
//    @Headers({"Accept: application/json"})
//    @POST("create-tutor")
//    Call<HomeTutorResponse> AddHomeTutor(
//            @Header("Authorization") String auth,
//            @Body HomeTutor homeTutor
//    );
//
//    @Headers({"Accept: application/json"})
//    @POST("create-dog-and-cat-mover")
//    Call<DogCatMoversResponse> AddDogCatMovers(
//            @Header("Authorization") String auth,
//            @Body DogCat dogCat
//    );
//    @POST("verify_forgotpass_otp")
//    Call<VerifyOtpResponse> verifyOtp(
//            @Query("forgot_pass_otp") String otp,
//            @Query("phone") String phn
//    );
//
//    @Headers({"Accept: application/json"})
//    @GET("profile")
//    Call<ProfileResponse> getprofile(
//            @Header("Authorization") String auth
//    );
//    @GET("leave_types")
//    Call<LeaveTypesResponse> gteLeaveTypes(
//            @Header("Authorization") String auth
//    );



}
