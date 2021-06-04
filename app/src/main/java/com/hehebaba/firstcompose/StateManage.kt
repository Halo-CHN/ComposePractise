package com.hehebaba.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hehebaba.firstcompose.viewmodel.ExpandViewModel
import com.hehebaba.firstcompose.viewmodel.HelloViewModel

class StateManage : ComponentActivity() {

    object Article {
        const val title = "滕王阁序"
        const val body =
            "豫章故郡，洪都新府。星分翼轸，地接衡庐。襟三江而带五湖，控蛮荆而引瓯越。物华天宝，龙光射牛斗之墟；人杰地灵，徐孺下陈蕃之榻。雄州雾列，俊采星驰。台隍枕夷夏之交，宾主尽东南之美。都督阎公之雅望，棨戟遥临；宇文新州之懿范，襜帷暂驻。十旬休假，胜友如云；千里逢迎，高朋满座。腾蛟起凤，孟学士之词宗；紫电清霜，王将军之武库。家君作宰，路出名区；童子何知，躬逢胜饯。 (豫章故郡 一作：南昌故郡；青霜 一作：清霜) \n\n" +
                    "时维九月，序属三秋。潦水尽而寒潭清，烟光凝而暮山紫。俨骖騑于上路，访风景于崇阿。临帝子之长洲，得天人之旧馆。层峦耸翠，上出重霄；飞阁流丹，下临无地。鹤汀凫渚，穷岛屿之萦回；桂殿兰宫，即冈峦之体势。（层峦 一作：层台；即冈 一作：列冈；飞阁流丹 一作：飞阁翔丹）\n\n" +
                    "披绣闼，俯雕甍，山原旷其盈视，川泽纡其骇瞩。闾阎扑地，钟鸣鼎食之家；舸舰弥津，青雀黄龙之舳。云销雨霁，彩彻区明。落霞与孤鹜齐飞，秋水共长天一色。渔舟唱晚，响穷彭蠡之滨，雁阵惊寒，声断衡阳之浦。(轴 通：舳；迷津 一作：弥津；云销雨霁，彩彻区明 一作：虹销雨霁，彩彻云衢) \n\n" +
                    "遥襟甫畅，逸兴遄飞。爽籁发而清风生，纤歌凝而白云遏。睢园绿竹，气凌彭泽之樽；邺水朱华，光照临川之笔。四美具，二难并。穷睇眄于中天，极娱游于暇日。天高地迥，觉宇宙之无穷；兴尽悲来，识盈虚之有数。望长安于日下，目吴会于云间。地势极而南溟深，天柱高而北辰远。关山难越，谁悲失路之人；萍水相逢，尽是他乡之客。怀帝阍而不见，奉宣室以何年？(遥襟甫畅 一作：遥吟俯畅) \n\n" +
                    "嗟乎！时运不齐，命途多舛。冯唐易老，李广难封。屈贾谊于长沙，非无圣主；窜梁鸿于海曲，岂乏明时？所赖君子见机，达人知命。老当益壮，宁移白首之心？穷且益坚，不坠青云之志。酌贪泉而觉爽，处涸辙以犹欢。北海虽赊，扶摇可接；东隅已逝，桑榆非晚。孟尝高洁，空余报国之情；阮籍猖狂，岂效穷途之哭！(见机 一作：安贫；以犹欢 一作：而相欢) \n\n" +
                    "勃，三尺微命，一介书生。无路请缨，等终军之弱冠；有怀投笔，慕宗悫之长风。舍簪笏于百龄，奉晨昏于万里。非谢家之宝树，接孟氏之芳邻。他日趋庭，叨陪鲤对；今兹捧袂，喜托龙门。杨意不逢，抚凌云而自惜；钟期既遇，奏流水以何惭？\n\n" +
                    "呜呼！胜地不常，盛筵难再；兰亭已矣，梓泽丘墟。临别赠言，幸承恩于伟饯；登高作赋，是所望于群公。敢竭鄙怀，恭疏短引；一言均赋，四韵俱成。请洒潘江，各倾陆海云尔：\n\n" +
                    "滕王高阁临江渚，佩玉鸣鸾罢歌舞。\n\n" +
                    "画栋朝飞南浦云，珠帘暮卷西山雨。\n\n" +
                    "闲云潭影日悠悠，物换星移几度秋。\n\n" +
                    "阁中帝子今何在？槛外长江空自流。"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


//            HelloScreen()
            HelloExpandingCard()
        }
    }

    @Preview(name = "Preview ExpandingCard", showBackground = true)
    @Composable
    fun DefaultPreview() {
//        HelloScreen()
        ExpandingCard(Article.title, Article.body)
    }
}

@Composable
fun HelloExpandingCard(expandViewModel: ExpandViewModel = viewModel()) {
    val expanded by expandViewModel.expanded.observeAsState(false)
    ExpandingCard(
        StateManage.Article.title,
        StateManage.Article.body,
        expanded,
        { expandViewModel.onExpandChange(true) },
        { expandViewModel.onExpandChange(false) })
}

@Composable
fun ExpandingCard(title: String, body: String) {
    var expended by remember {
        mutableStateOf(false)
    }
    val typography = MaterialTheme.typography
    Card {
        Column(
            Modifier
                .animateContentSize(animationSpec = TweenSpec(durationMillis = 1000))
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = title,
                style = typography.h5,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            if (expended) {
                Text(text = body, Modifier.padding(top = 8.dp), style = typography.body1)
                IconButton(modifier = Modifier.fillMaxWidth(), onClick = {
                    expended = false
                }) {
                    Icon(imageVector = Icons.Default.ExpandLess, contentDescription = "Expand less")
                }
            } else {
                IconButton(modifier = Modifier.fillMaxWidth(), onClick = {
                    expended = true
                }) {
                    Icon(imageVector = Icons.Default.ExpandMore, contentDescription = "Expand more")
                }
            }
        }
    }
}

@Composable
fun ExpandingCard(
    title: String,
    body: String,
    expanded: Boolean,
    onExpand: () -> Unit,
    onCollapse: () -> Unit
) {
    val typography = MaterialTheme.typography
    Card {
        Column(
            Modifier
                .animateContentSize(animationSpec = TweenSpec(durationMillis = 1000))
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = typography.h5)

            if (expanded) {
                Text(text = body, Modifier.padding(top = 8.dp), style = typography.body1)
                IconButton(modifier = Modifier.fillMaxWidth(), onClick = onCollapse) {
                    Icon(imageVector = Icons.Default.ExpandLess, contentDescription = "Expand less")
                }
            } else {
                IconButton(modifier = Modifier.fillMaxWidth(), onClick = onExpand) {
                    Icon(imageVector = Icons.Default.ExpandMore, contentDescription = "Expand more")
                }
            }
        }
    }
}

@Composable
fun HelloScreen(helloViewModel: HelloViewModel = viewModel()) {
    val name by helloViewModel.name.observeAsState("")
    HelloContent(name, onNameChange = { helloViewModel.onNameChange(it) })
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (name.isNotEmpty()) {
            Text(
                text = "Hello $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        OutlinedTextField(
            value = name,
            label = { Text(text = "Name") },
            onValueChange = onNameChange
        )
    }
}
