package com.proptit.budgetbuddy.presentation.util

import com.proptit.budgetbuddy.BuildConfig
import com.proptit.budgetbuddy.R

object Constant {
    const val CATEGORY_ID = "category_id"
    const val CATEGORY_TYPE = "category_type"
    const val CURRENT_TAB_POSITION = "currentTabPosition"
    private val categoryIconLists = listOf<String>(
        "Foods",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_food}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_rice}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_silken_tofu}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_meat}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_fish}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_crab}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_icecream}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bread}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cake}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_steak}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_kawaii_egg}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_kawaii_pizza}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_kawaii_sushi}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_noodles}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_kawaii_taco}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cherry_chupa_chups}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_chocolate_bar}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_deliver_food}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_dim_sum}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_fries}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_baguette}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_blue_ice_pop}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_food_cart}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_pumpkin}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_fruits}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_grapes}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_lemon}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_strawberry}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_nut}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_flour}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_mushroom}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_restaurant_table}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_birthday_cake}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_eggplant}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_lunchbox}",
        "Drink",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_coffee_to_go}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_coffee}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_oat_milk}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_champagne}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_beverages}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_beer}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cocktail}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_alcohol}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_coconut_cocktail}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bottle_of_water}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_juice_bottle}",
        "Shopping",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_shopping}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_buying}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_atm}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_click_collect}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cash_register}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_online_payment}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_pos_terminal}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_price_tag}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_shopping_bag}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_small_business}",
        "Shoes",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_shoe}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_flip_flops}",
        "Clothes",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_clothes}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_t_shirt}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_skirt}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bathrobe}",
        "Wear",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_glasses}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_detective_hat}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_handbags}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_diamond}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_diamond_ring}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_scarf}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_smart_watch}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_backpack}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_gold_hallmark}",
        "Beauty",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_haircut}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_lipstick}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_straight_razor}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_perfume}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_manicure}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_hairdryer}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_electric_shaver}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_eyelash}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_beard_trimmer}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_afro_pick}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_ear_piercing}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_beautician}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_spa_flower}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_spa_mask}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_dressing_table}",
        "Work",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_wage}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_usecomputer}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_settings}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_pen}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_handshake}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_engineer}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_teamwork}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_art_prices}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_home_office}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_ruler}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_learning}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_enterprise_resource_planning}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_drafting_compass}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_foundation}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_spade}",
        "Finance",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_moneybag}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_getcash}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cash}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cheque}",
        "Learning",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_children_study}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_education}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_school}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_book_shelf}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_hand_with_pen}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_course}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_classroom}",
        "Traffic",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_plane}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bus}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_taxi}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_boat}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_auto_rickshaw}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cycling}",
        "Sports",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_running}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_football}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_swimming}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_basketball_net}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bowling}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_american_football_player}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_baseball}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_shuttlecock}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_snowboarding}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_body_positive_female}",
        "Babies",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_baby}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_onesies}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_nappy}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_red_childrens_tights}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_teddy}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_sylvanian_families}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_pacifier}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_pram}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_claw_machine}",
        "Pets",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_pet}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cat}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_dog}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_dog_bowl}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_frog_face}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_aquarium}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_running_away}",
        "Family",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_household}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_home}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bathcrock}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_machine_wash_warm}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_picture}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_idea}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_survivalbag}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_electrical}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_electric_toothbrush}",
        "Automobile",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_car}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_petrolstation}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_steering_wheel}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_car_service}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_car_battery}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_parking}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_garage}",
        "Recreational",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_game}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_music}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_musical}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_chess}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_dice}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_fishing}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_poker}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_micro}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_dancing}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_party}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_firework}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_sun}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_party_balloons}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_film_soundtracks}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_movie_ticket}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_movie}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_confetti}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_gift}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_park}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_dj}",
        "Travel",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_holiday}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_hot_springs}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_campfire}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_passport}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_floating_island_beach}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_flash_light}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_mountain}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_forest}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_national_park}",
        "Farming",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bull}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cow}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_chicken}",
        "Plants",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_bonsai}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_sunflower}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_sugarcane}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_oak_tree}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_leaf}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_grass}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_garden_sprinkler}",
        "Healthcare",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_medical}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_acupuncture}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_survivalbag}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_medical_doctor}",
        "Devices",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_imac}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_printer}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_computer}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_charging_battery}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_cd}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_keyboard}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_mouse}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_phone}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_category}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_hdd}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_camera}",
        "Others",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_app_store}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_apple_tv}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_google_play}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_internet}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_about}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_crown}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_more}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_buddha}",
        "android.resource://${BuildConfig.APPLICATION_ID}/drawable/"+"${R.drawable.ic_church}",
    )

    fun getCategoryIconLists(): List<String>{
        return categoryIconLists.toList()
    }
}